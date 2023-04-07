import java.util.ArrayList;
import java.util.List;


public class Cage implements IIsolation{
    List<Monkey> monkeys;

    /**
     * Construct a new Cage object with an empty list of monkeys.
     */
    Cage(){
        monkeys = new ArrayList<>();
    }

    /**
     * Add a monkey to an empty cage
     *
     * @param monkey The monkey to add to the cage
     */

    @Override
    public void add(Monkey monkey) {
        if (monkeys.isEmpty()) {
            monkeys.add(monkey);
        }
    }

    /**
     * Once the monkey have received medical attention, it would be removed from isolation
     * and moved to enclosure spaces
     *
     * @param monkey The monkey to remove from the cage
     */
    @Override
    public void remove(Monkey monkey) {
        monkeys.remove(monkey);
    }

    /**
     * Return a list of monkeys that currently in the isolation housing
     *
     * @return a list of monkeys that currently in the isolation housing
     */
    @Override
    public List<Monkey> getMonkeys() {
        return monkeys;
    }
}
