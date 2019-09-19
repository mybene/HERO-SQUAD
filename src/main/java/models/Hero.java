package models;


import java.util.ArrayList;
//import java.util.List;

public class Hero {

    private static String  Iname;
    private static  int Iage;
    private  static String Ipower;
    private static  String Iweakness;
    private  static  int id;
    private  static ArrayList<Hero> instances=new ArrayList<>();

    public Hero(String name, int age, String power, String weakness) {
        this.Iname = name;
        this.Iage = age;
        this.Ipower = power;
        this.Iweakness = weakness;
        instances.add(this);
        this.id=instances.size();
    }

    public static void clear() {

        instances.clear();
    }

    public String getName() {

        return Iname;
    }

    public int getAge() {

        return Iage;
    }


    public static String getPower() {

        return Ipower;
    }

    public static String getWeakness() {
        return Iweakness;
    }

    public static ArrayList<Hero> getInstances() {

        return instances;
    }

    public static Hero find(int id) {

        return instances.get(id -1);
    }

    public static  Hero gotNewHero(){
        return  new Hero ("Supergirl",18,"shooting arrow","fogther");
    }
    public static  Hero gotNewHero1(){
        return  new Hero ("Jamie",21,"white snow","fire");
    }
    public static  Hero gotNewHero2(){
        return  new Hero ("IronMan",40,"never get tired","forget quiclky");
    }


    public int getId() {
        return id;
    }
}
