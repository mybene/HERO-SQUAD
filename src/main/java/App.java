
import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;
public class App {
    public static  void main(String[] args){
        staticFileLocation("/public");
        ProcessBuilder process= new ProcessBuilder();
        Integer port;

        if(process.environment().get("PORT") != null){
            port = Integer.parseInt(process.environment().get("PORT"));
        }
        else{
            port =4567;
        }
        port(port);

        staticFileLocation("/public");

        Hero.gotNewHero();
        Hero.gotNewHero1();
        Hero.gotNewHero2();
        Squad.gotNewSquad();
        Squad.gotNewSquad1();


        get("/",(req,res)->{
            Map<String,Object>model = new HashMap<>();
            return new ModelAndView(model,"home.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero-form",(req,res)->{
            Map<String,Object>model = new HashMap<>();
            return new ModelAndView(model,"heroForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero",(req,res)->{
            Map<String,Object>model = new HashMap<>();
            List<Hero> newHero=Hero.getInstances();
            model.put("heroes",newHero);
            return new ModelAndView(model,"hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad-form",(req,res)->{
            Map<String,Object>model = new HashMap<>();
            return new ModelAndView(model,"squadForm.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad",(req,res)->{
            Map<String,Object>model = new HashMap<>();
            List<Squad> newSquad= Squad.getInstances();
            model.put("squad",newSquad);
            List<Hero> members=Hero.getInstances();
            model.put("heroes",members);
            Squad squad = Squad.gotNewSquad();
            model.put("allSquadMemebrs",squad.getSnames());
            return  new ModelAndView(model,"squad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/new",(req,res)->{
            Map<String,Object>model = new HashMap<>();
            String squadName = req.queryParams("squadName");
            Integer squadSize = Integer.parseInt(req.queryParams("squadSize"));
            String squadCause= req.queryParams("squadCause");
            Squad newSquad = new Squad(squadName,squadSize,squadCause);
            req.session().attribute("item",squadName);
            model.put("item",req.session().attribute("item"));
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

        get("/new/member/;squadId",(req,res)->{
            Map<String, Object>model= new HashMap<>();
            req.session().attribute("selectedSquad",req.params("squadId"));
            model.put("selectedSquad",req.session().attribute("selectedSquad"));
            model.put("item",1);
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

        get("/squad/new/:id",(req,res)->{
            Map<String,Object>model = new HashMap<>();
            int id = Integer.parseInt(req.params(":id"));
            Hero newMember = Hero.find(id);
            Squad newSquad = Squad.gotNewSquad();
            newSquad.setNewHero(newMember);
            model.put("item",newMember.getName());
            model.put("newHero",newSquad.getSnames());
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());


    }


}