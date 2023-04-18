package model.housing;


import model.monkey.Monkey;
import java.util.List;

/**
 * This interface represents a housing space for monkeys.
 */
public interface HousingSpace {

    /**
     * Add a monkey to a housing space
     * @param monkey The monkey to add to the housing space
     */
    void add(Monkey monkey);

    /**
     * Remove a monkey from the housing space
     * @param monkey The monkey to remove from the housing space
     */
    void remove(Monkey monkey);

    /**
     * Return a list of monkeys that currently in the housing space
     * @return a list of monkeys that currently in the housing space
     */
    List<Monkey> getMonkeys();

}
