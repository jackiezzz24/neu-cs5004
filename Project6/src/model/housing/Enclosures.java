package model.housing;

import model.monkey.Monkey;
import model.monkey.Species;
import java.util.ArrayList;
import java.util.List;

/**
 * The enclosures class implements the HousingSpace interface. It represents the enclosures space
 * for monkeys. Each enclosure space housed one species of monkeys.
 * The sanctuary consists of eight enclosures spaces.
 */
public class Enclosures implements HousingSpace {

    Species species;
    List<Monkey> monkeys;

    /**
     * Construct a new Enclosure object for the given species with an empty list of monkeys.
     * @param species The species of monkeys that the enclosure is housed
     */
    Enclosures(Species species){
        this.species = species;
        monkeys = new ArrayList<>();
    }

    /**
     * Return the species that is currently housed in the enclosure
     * @return the species that is currently housed in the enclosure
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * Add a monkey to an enclosure space if its species the same as the enclosure species
     * and monkey has received the medical attention
     *
     * @param monkey The monkey to add to the enclosures
     */
    @Override
    public void add(Monkey monkey) {
        if (monkey.getSpecies() == species && monkey.isMedicalAttention()) {
            monkeys.add(monkey);
            System.out.println("Monkey " + monkey.getName() + " moved to enclosure successfully.");
        }
    }

    /**
     * Remove a monkey from the housing space
     *
     * @param monkey The monkey to remove from the housing space
     */
    @Override
    public void remove(Monkey monkey) {
        monkeys.remove(monkey);
    }

    /**
     * Return a list of monkeys that currently in the enclosures space
     *
     * @return a list of monkeys that currently in the enclosures space
     */
    @Override
    public List<Monkey> getMonkeys() {
        return monkeys;
    }
}
