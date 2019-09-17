import models.Squad;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquadTest {
    @Test
    public  void  newSquad_instantiatesCorrectly(){
        Squad testSquad= new Squad("Avengers",4,"patriotism");
        assertEquals(true,testSquad instanceof Squad);

    }
    @Test
    public  void  newSquad_getName_String(){
        Squad testSquad= new Squad("Avengers",4,"patriotism");
        String newSquad="Avengers";
        assertEquals(newSquad,testSquad.getSnames());
    }

    @Test
    public  void  newSquad_setSize_int(){
        Squad testSquad= new Squad("Avengers",4,"patriotism");
        int newSquad=4;
        assertEquals(newSquad,testSquad.getSmember());
    }

    @Test
    public void newSquad_setCause_string(){
        Squad testSquad= new Squad("Avengers",4,"patriotism");
        String newSquad="figthers";
        assertEquals(newSquad,testSquad.getCause());
    }

    @Test
    public  void newSquad_getInstances_true(){
        Squad newSquad= Squad.gotNewSquad();
        Squad otherSquad= Squad.gotNewSquad1();
        assertTrue(Squad.getInstances().contains(newSquad));
        assertTrue(Squad.getInstances().contains(otherSquad));
    }

    @Test
    public void newSquad_addHero_Array(){
        models.Squad newSquad = models.Squad.gotNewSquad();
        models.Hero newHero = models.Hero.gotNewHero();
        models.Hero newHero1= models.Hero.gotNewHero1();
        newSquad.addHero(newHero);
        assertEquals("flash",newSquad.addHero().get(0).getName());
    }
    @Test
    public void newSquad_allTestSquadHeroes_Array(){
        models.Hero newHero= models.Hero.gotNewHero();
        models.Squad newSquad= models.Squad.gotNewSquad();
        newSquad.clearAllSquadHeroes();
        newSquad.addHero().add(newHero);
        assertEquals(2,newSquad.addHero().size());
    }

    @Test
    public void findHero_initializeEmptyLIst_ArrayList(){
        models.Squad testSquad= new models.Squad("Avengers",10,"patriotism");
        models.Squad.clear();
        assertEquals(0,testSquad.addHero().size());
    }
    @Test
    public void setNewHero_hero(){
        models.Hero.clear();
        models.Hero newHero = models.Hero.gotNewHero();
        models.Squad testSquad = models.Squad.gotNewSquad();
        testSquad.setNewHero(newHero);
        assertEquals(1,testSquad.addHero().get(0).getId());
    }



}
