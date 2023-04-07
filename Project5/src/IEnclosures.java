import java.util.List;

/**
 * This interface represents an enclosure space for monkeys.
 * Enclosure housing can host a single troop of monkeys. Each troop consists of a single species
 * There are eight enclosure spaces in the sanctuary.
 */
public interface IEnclosures {

    /**
     * Add a monkey to an enclosure space
     * @param monkey The monkey to add to the enclosures
     */
    void add(Monkey monkey);

    /**
     * Return a list of monkeys that currently in the enclosures space
     * @return a list of monkeys that currently in the enclosures space
     */
    List<Monkey> listOfMonkeys();

    Species getSpecies();
}
