import java.util.List;

/**
 * This interface represents an isolation housing for monkeys.
 * Isolation housing is used to keep monkeys when they first arrive at the sanctuary and
 * anytime they are receiving medical attention. Isolation consists of twenty cages each
 * of which can house a single monkey.
 */
public interface IIsolation {


    /**
     * Add a monkey to an empty cage
     * @param monkey The monkey to add to the cage
     */
    void add(Monkey monkey);

    /**
     * Once the monkey have received medical attention, it would be removed from isolation
     * and moved to enclosure spaces
     * @param monkey The monkey to remove from the cage
     */
    void remove(Monkey monkey);

    /**
     * Return the list of monkeys that currently in the isolation housing
     * @return the list of monkeys that currently in the isolation housing
     */
    List<Monkey> getMonkeys();

}
