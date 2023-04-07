import java.util.ArrayList;
import java.util.List;

public class Enclosure implements IEnclosures {

    Species species;
    List<Monkey> monkeys;

    /**
     * Construct a new Enclosure object for the given species with an empty list of monkeys.
     * @param species The species of monkeys that the enclosure is housed
     */
    Enclosure(Species species){
        this.species = species;
        monkeys = new ArrayList<>();
    }

    public Species getSpecies() {
        return species;
    }

    /**
     * Add a monkey to an enclosure space
     *
     * @param monkey The monkey to add to the enclosures
     */
    @Override
    public void add(Monkey monkey) {
        if (monkey.getSpecies() == species) {
            monkeys.add(monkey);
        }
    }

    /**
     * Return a list of monkeys that currently in the enclosures space
     *
     * @return a list of monkeys that currently in the enclosures space
     */
    @Override
    public List<Monkey> listOfMonkeys() {
        return monkeys;
    }
}
