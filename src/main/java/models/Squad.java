
package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Squad {

    private String squadName;
    private int squadSize;
    private  String squadCause;
    private static ArrayList<Squad> instances=new ArrayList<Squad>();
    private int squadId;
    private ArrayList<models.Hero>squadHeroes=new ArrayList<>();



    public Squad(String sName, int sSize, String sCause) {
        this.squadName = sName;
        this.squadSize = sSize;
        this.squadCause = sCause;
        instances.add(this);
        this.squadId=instances.size();
        this.squadHeroes=new ArrayList<>();
    }




    public String getSnames() {

        return squadName;
    }

    public String getCause() {
        return squadCause;

    }

    public int getSmember() {

        return squadSize;
    }

    public static void clear() {

        instances.clear();
    }

    public int getId() {
        return squadId;
    }
    public static List<Squad> getInstances(){
        return instances;
    }

    public static Squad findSquadId(int id) {

        return instances.get(id -1);
    }

    public ArrayList<models.Hero> addHero() {

        return squadHeroes;
    }

    public void addHero(models.Hero newMember) {

        squadHeroes.add(newMember);
    }


    public  static  Squad gotNewSquad() {
        return new Squad("Inkotanyi", 4, "fighter");
    }
    public static Squad gotNewSquad1(){
        return  new Squad("Musketeers",3," Throne's Guardian ");
    }

    public void clearAllSquadHeroes() {
        addHero().clear();
    }

    public void setNewHero(Hero newHero) {
        squadHeroes.add(newHero);

    }
}
