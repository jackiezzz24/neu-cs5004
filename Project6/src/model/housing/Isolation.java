package model.housing;

import model.monkey.Monkey;

import java.util.ArrayList;
import java.util.List;

/**
 * The isolation class implements the HousingSpace interface. It represents the isolation space
 * for monkeys. The isolation space consists of 20 cages. Each cage can house one monkey.
 */

public class Isolation implements HousingSpace {
    List<Monkey> monkeys;
    private static final int CAGE_SIZE = 20;
    /**
     * Construct an isolation object with an empty list of monkeys.
     */
    Isolation(){
        monkeys = new ArrayList<>();
    }

    /**
     * Add a monkey to an empty cage
     *
     * @param monkey The monkey to add to the cage
     */

    @Override
    public void add(Monkey monkey) {
        if (monkeys.size() > CAGE_SIZE) {
            throw new IllegalStateException("There is no space in the isolation housing.");
        }
            monkeys.add(monkey);
            System.out.println("Monkey " + monkey.getName() + " added to isolation successfully.");
    }

    /**
     * Once the monkey have received medical attention, it would be removed from isolation
     * and moved to enclosure spaces
     *
     * @param monkey The monkey to remove from the cage
     */
    @Override
    public void remove(Monkey monkey) {
        if (!monkey.isMedicalAttention()) {
            throw new IllegalStateException("Medical attention hasn't finished. Monkey "
                    + monkey.getName()
                    + " cannot move to enclosure.");
        } else {
            monkeys.remove(monkey);
        }
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
