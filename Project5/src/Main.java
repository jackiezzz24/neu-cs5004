import model.housing.Sanctuary;
import model.monkey.Food;
import model.monkey.Monkey;
import model.monkey.Sex;
import model.monkey.Species;

public class Main {
    public static void main(String[] args) {
        Monkey monkey1 = new Monkey("Joe", Species.Drill, Sex.M, 30.2, 23.1, 1, Food.Eggs);
        Monkey monkey2 = new Monkey("Coco", Species.Drill, Sex.F, 25.7, 20.9, 1, Food.Fruits);
        Monkey monkey3 = new Monkey("Max", Species.Guereza, Sex.M, 15.3, 9.8, 2, Food.Insects);
        Monkey monkey4 = new Monkey("Lily", Species.Howler, Sex.F, 24.6, 13.5, 1, Food.Leaves);
        Monkey monkey5 = new Monkey("Lisa", Species.Tamarin, Sex.F, 30.2, 23.1, 2, Food.Nuts);

        Sanctuary sanctuary = new Sanctuary();
        sanctuary.addToIsolation(monkey1);
        sanctuary.addToIsolation(monkey2);
        sanctuary.addToIsolation(monkey3);
        sanctuary.addToIsolation(monkey4);
        sanctuary.addToIsolation(monkey5);
        monkey1.setMedicalAttention(true);
        monkey2.setMedicalAttention(true);
        monkey3.setMedicalAttention(true);
        sanctuary.moveToEnclosure(monkey1);
        sanctuary.moveToEnclosure(monkey2);
        sanctuary.moveToEnclosure(monkey3);
        sanctuary.moveToEnclosure(monkey4);
        sanctuary.moveToEnclosure(monkey5);
        System.out.println(sanctuary.monkeyListForIsolation());
        System.out.println(sanctuary.monkeyListForEnclosure());
        System.out.println(sanctuary.monkeyList());

    }
}