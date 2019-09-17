import models.Hero;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HeroTest {
    private String name;
    private int age;
    private String power;


    @Test
    public void  addHero_instantiatesCorrectly_true(){
        Hero testHero= new Hero("Supergirl",18,"shooting arrow","figther");
        assertEquals(true,testHero);
    }

    @Test
    public  void  addHero_getName_string(){
        Hero testHero= new Hero("Supergirl",18,"shooting arrow","figther");
        String newHero="Ndabaga";
        assertEquals(newHero,testHero.getName());;
    }

    @Test
    public  void addHero_getAge_Int(){
        Hero testHero= new Hero("Supergirl",18,"shooting arrow","figther");
        int newHero=18;
        assertEquals(newHero,testHero.getAge());
    }

    @Test
    public  void  addHero_getPower_string(){
        Hero testHero= new Hero("Supergirl",18,"shooting arrow","figther");
        String newHero="kumasha";
        assertEquals(newHero,testHero.getPower());;
    }

    @Test
    public  void  addHero_getWeakness_string(){
        Hero testHero= new Hero("Supergirl",18,"shooting arrow","figther");
        String newHero="Gusimbuka imangaa";
        assertEquals(newHero,testHero.getWeakness());;
    }

    @Test
    public void addHero_getId_int() {
        Hero testHero= new Hero("Supergirl",18,"shooting arrow","figther");
        Hero.clear();
        assertEquals(1,testHero.getId());
    }
}

