import java.awt.desktop.ScreenSleepEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sanctuary {

    List<IIsolation> cages;
    List<IEnclosures> enclosures;
    List<Monkey> monkeys;
    private static final int CAGE_SIZE = 20;
    Sanctuary() {
        cages = new ArrayList<>();
        enclosures = new ArrayList<>();
        monkeys = new ArrayList<>();
        for (int i = 0; i < CAGE_SIZE; i++) {
            cages.add(new Cage());
        }
        for (Species species: Species.values()) {
            enclosures.add(new Enclosure(species));
        }
    }
    public void addToIsolation(Monkey monkey) {
        for (IIsolation cage: cages) {
            if (cage.getMonkeys() == null) {
                cage.add(monkey);
            }
        }
        if (!cages.contains(null)) {
            System.out.println("There is no space in the isolation housing.");
        } else {
            monkeys.add(monkey);
        }
    }

    public void moveToEnclosure(Monkey monkey) {
        for (IIsolation cage: cages) {
            if(cage.getMonkeys().contains(monkey) && monkey.isMedicalAttention()) {
                cage.remove(monkey);
            }
        }
        for (IEnclosures enclosure: enclosures) {
            if (enclosure.getSpecies().equals(monkey.getSpecies())) {
                enclosure.add(monkey);
            }
        }
    }

    public void monkeyListForEnclosure(Species species) {
        List<Monkey> monkeysForEnclosure = null;
        for (IEnclosures enclosure: enclosures) {
            if (enclosure.getSpecies().equals(species)){
                monkeysForEnclosure = enclosure.listOfMonkeys();
            }
        }
        if (monkeysForEnclosure.isEmpty()) {
            System.out.println("There is no monkey in this enclosure space.");
        } else {
            for (Monkey monkey: monkeysForEnclosure){
                System.out.println("Name: " + monkey.getName() + "\n"
                        + "Sex: " + monkey.getSex() + "\n"
                        + "Favorite Food: " + monkey.getFavoriteFood() + "\n");
            }
        }
    }

    public void monkeyList() {
        monkeys.sort(new Comparator<Monkey>() {
            @Override
            public int compare(Monkey o1, Monkey o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Monkey monkey: monkeys) {
            System.out.println("Name: " + monkey.getName() + "\n"
                    + "Sex: " + monkey.getSex() + "\n"
                    + "Favorite Food: " + monkey.getFavoriteFood() + "\n");
        }
    }
}
