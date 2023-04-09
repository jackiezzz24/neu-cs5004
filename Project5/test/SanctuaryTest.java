import model.housing.Sanctuary;
import model.monkey.Food;
import model.monkey.Monkey;
import model.monkey.Sex;
import model.monkey.Species;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test case for Sanctuary class
 */
class SanctuaryTest {
    Monkey monkey1;
    Monkey monkey2;
    Monkey monkey3;
    Monkey monkey4;
    Monkey monkey5;
    Sanctuary sanctuary;

    @BeforeEach
    void setUp() {
        monkey1 = new Monkey("Joe", Species.Drill, Sex.M, 30.2, 23.1, 1, Food.Eggs);
        monkey2 = new Monkey("Coco", Species.Drill, Sex.F, 25.7, 20.9, 1, Food.Fruits);
        monkey3 = new Monkey("Max", Species.Guereza, Sex.M, 15.3, 9.8, 2, Food.Insects);
        monkey4 = new Monkey("Lily", Species.Howler, Sex.F, 24.6, 13.5, 1, Food.Leaves);
        monkey5 = new Monkey("Lisa", Species.Saki, Sex.F, 30.2, 23.1, 2, Food.Nuts);
        sanctuary = new Sanctuary();
    }

    @Test
    void testMonkey(){
        assertEquals("Name: Joe\n"
                + "Species: Drill\n"
                + "Sex: M\n"
                + "Size: 30.2\n"
                + "Weight: 23.1\n"
                + "Age: 1\n"
                + "Favorite Food: Eggs\n", monkey1.toString());

        assertThrows(IllegalArgumentException.class, ()->{
            new Monkey("Joe", Species.Drill, Sex.M, -30.2, 23.1, 1, Food.Eggs);});
    }

    @Test
    void addToIsolation() {
        sanctuary.addToIsolation(monkey1);
        sanctuary.addToIsolation(monkey2);
        assertTrue(sanctuary.getIsolation().getMonkeys().contains(monkey1));
        assertTrue(sanctuary.getIsolation().getMonkeys().contains(monkey2));
        assertFalse(sanctuary.getIsolation().getMonkeys().contains(monkey3));
    }

    @Test
    void testIsolationAllCapacity(){
        int CAGE_SIZE = 20;
        for (int i = 1; i <= CAGE_SIZE; i++) {
            sanctuary.addToIsolation(
                    new Monkey("Monkey" + i, Species.Drill, Sex.M, 30.2, 23.1, 1, Food.Eggs));
        }

        Monkey newMonkey = new Monkey("new", Species.Drill, Sex.M, 30.2, 23.1, 1, Food.Eggs);
        sanctuary.addToIsolation(newMonkey);

        assertFalse(sanctuary.getIsolation().getMonkeys().contains(newMonkey));
    }


    @Test
    void moveToEnclosure() {
        // Test that a monkey cannot be added to an enclosure if it has not been labelled as healthy
        sanctuary.addToIsolation(monkey3);
        sanctuary.moveToEnclosure(monkey3);
        assertTrue(sanctuary.getIsolation().getMonkeys().contains(monkey3));
        assertFalse(sanctuary.getEnclosures(monkey3.getSpecies()).getMonkeys().contains(monkey3));

        // Test that a monkey can be moved from isolation to an enclosure
        monkey3.setMedicalAttention(true);
        sanctuary.moveToEnclosure(monkey3);
        assertFalse(sanctuary.getIsolation().getMonkeys().contains(monkey3));
        assertTrue(sanctuary.getEnclosures(monkey3.getSpecies()).getMonkeys().contains(monkey3));

        // Test that species that are currently being housed in the sanctuary is correct
        sanctuary.addToIsolation(monkey4);
        monkey4.setMedicalAttention(true);
        sanctuary.moveToEnclosure(monkey4);
        assertEquals(sanctuary.getEnclosures(monkey3.getSpecies()).getSpecies(), monkey3.getSpecies());
        assertEquals(sanctuary.getEnclosures(monkey4.getSpecies()).getSpecies(), monkey4.getSpecies());

    }

    @Test
    void monkeyListForIsolation() {
        sanctuary.addToIsolation(monkey1);
        sanctuary.addToIsolation(monkey5);
        monkey1.setMedicalAttention(true);
        sanctuary.moveToEnclosure(monkey1);
        String expected = "\nIsolation:\n"
                + "Name: Lisa\n"
                + "Sex: F\n"
                + "Favorite Food: Nuts\n";
        assertEquals(expected, sanctuary.monkeyListForIsolation());

        monkey5.setMedicalAttention(true);
        sanctuary.moveToEnclosure(monkey5);
        String expected_null = "\nIsolation:\n"
            + "There is no monkey in this isolation space.\n";
        assertEquals(expected_null, sanctuary.monkeyListForIsolation());
    }
    @Test
    void monkeyListForEnclosure() {
        sanctuary.addToIsolation(monkey1);
        sanctuary.addToIsolation(monkey5);
        monkey1.setMedicalAttention(true);
        monkey5.setMedicalAttention(true);
        sanctuary.moveToEnclosure(monkey1);
        sanctuary.moveToEnclosure(monkey5);
        String expected = "\nEnclosure - Drill:\n"
                + "Name: Joe\n"
                + "Sex: M\n"
                + "Favorite Food: Eggs\n"
                + "\nEnclosure - Guereza:\n"
                + "There is no monkey in this enclosure space.\n"
                + "\nEnclosure - Howler:\n"
                + "There is no monkey in this enclosure space.\n"
                + "\nEnclosure - Mangabey:\n"
                + "There is no monkey in this enclosure space.\n"
                + "\nEnclosure - Saki:\n"
                + "Name: Lisa\n"
                + "Sex: F\n"
                + "Favorite Food: Nuts\n"
                + "\nEnclosure - Spider:\n"
                + "There is no monkey in this enclosure space.\n"
                + "\nEnclosure - Squirrel:\n"
                + "There is no monkey in this enclosure space.\n"
                + "\nEnclosure - Tamarin:\n"
                + "There is no monkey in this enclosure space.\n";
        assertEquals(expected, sanctuary.monkeyListForEnclosure());


    }

    @Test
    void monkeyList() {
        sanctuary.addToIsolation(monkey1);
        sanctuary.addToIsolation(monkey2);
        sanctuary.addToIsolation(monkey3);
        sanctuary.addToIsolation(monkey4);
        sanctuary.addToIsolation(monkey5);
        monkey2.setMedicalAttention(true);
        monkey4.setMedicalAttention(true);
        monkey5.setMedicalAttention(true);
        sanctuary.moveToEnclosure(monkey2);
        sanctuary.moveToEnclosure(monkey4);
        sanctuary.moveToEnclosure(monkey5);
        String expected = "\nAll the monkeys in the sanctuary: \n"
                + "Name: Coco\n"
                + "Sex: F\n"
                + "Favorite Food: Fruits\n"
                + "Name: Joe\n"
                + "Sex: M\n"
                + "Favorite Food: Eggs\n"
                + "Name: Lily\n"
                + "Sex: F\n"
                + "Favorite Food: Leaves\n"
                + "Name: Lisa\n"
                + "Sex: F\n"
                + "Favorite Food: Nuts\n"
                + "Name: Max\n"
                + "Sex: M\n"
                + "Favorite Food: Insects\n";
        assertEquals(expected, sanctuary.monkeyList());
    }
}