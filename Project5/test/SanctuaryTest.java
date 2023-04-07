import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        monkey5 = new Monkey("Lisa", Species.Howler, Sex.F, 30.2, 23.1, 2, Food.Nuts);
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
        assertTrue(sanctuary.cages.contains(monkey1));

    }
}