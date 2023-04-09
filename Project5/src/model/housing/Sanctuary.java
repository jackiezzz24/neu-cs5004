package model.housing;

import model.monkey.Monkey;
import model.monkey.Species;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A Sanctuary class that manages isolation and enclosure spaces and monkeys in the sanctuary.
 *
 */
public class Sanctuary {

    Isolation isolation;
    List<Enclosures> enclosures;
    List<Monkey> monkeys;


    /**
     * Constructs a new Sanctuary object that includes an Isolation object and Enclosures for each Species value.
     */
    public Sanctuary() {
        isolation = new Isolation();
        enclosures = new ArrayList<>();
        monkeys = new ArrayList<>();
        for (Species species: Species.values()) {
            enclosures.add(new Enclosures(species));
        }
    }

    /**
     * Returns the Isolation object of the Sanctuary.
     * @return the Isolation object of the Sanctuary.
     */
    public Isolation getIsolation() {
        return isolation;
    }

    /**
     * Returns the enclosure for the given species, or null if the enclosure cannot find.
     * @param species the species of monkey that the enclosure housed
     * @return the enclosure for the given species, or null if the enclosure cannot find.
     */
    public Enclosures getEnclosures(Species species) {
        for (Enclosures enclosure: enclosures) {
            if (enclosure.getSpecies() == species) {
                return enclosure;
            }
        }
        return null;
    }

    /**
     * Adds the given monkey to the isolation area of the sanctuary and also adds it to the list of monkeys.
     * @param monkey  the monkey to be added to isolation
     */
    public void addToIsolation(Monkey monkey) {
        isolation.add(monkey);
        monkeys.add(monkey);
    }

    /**
     * Moves the monkey from the isolation area to an enclosure, if the monkey received medical attention
     * @param monkey the monkey to be moved to an enclosure.
     */
    public void moveToEnclosure(Monkey monkey) {
        isolation.remove(monkey);
        for (Enclosures enclosure : enclosures) {
            if (enclosure.getSpecies().equals(monkey.getSpecies())) {
                enclosure.add(monkey);
            }
        }
    }

    /**
     * Return the monkey list housed in the isolation
     * @return the monkey list housed in the isolation
     */
    public String monkeyListForIsolation() {
        StringBuilder sb = new StringBuilder();
        List<Monkey> monkeysForIsolation = isolation.getMonkeys();
        monkeysForIsolation.sort(new Comparator<Monkey>() {
            @Override
            public int compare(Monkey o1, Monkey o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        sb.append("\nIsolation:\n");
        if (monkeysForIsolation.size() < 1) {
            sb.append("There is no monkey in this isolation space.\n");
        } else {
            for (Monkey monkey : monkeysForIsolation) {
                sb.append("Name: ").append(monkey.getName()).append("\n")
                        .append("Sex: ").append(monkey.getSex()).append("\n")
                        .append("Favorite Food: ").append(monkey.getFavoriteFood()).append("\n");
            }
        }
        return sb.toString();
    }

    /**
     * Return the monkey list housed in every enclosure
     * @return the monkey list housed in every enclosure
     */
    public String monkeyListForEnclosure() {
        StringBuilder sb = new StringBuilder();
        for (Enclosures enclosure: enclosures) {
            List<Monkey> monkeysForEnclosure = enclosure.getMonkeys();
            monkeysForEnclosure.sort(new Comparator<Monkey>() {
                @Override
                public int compare(Monkey o1, Monkey o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            sb.append("\nEnclosure - ").append(enclosure.getSpecies()).append(":\n");
            if (monkeysForEnclosure.size() < 1) {
                sb.append("There is no monkey in this enclosure space.\n");
            } else {
                for (Monkey monkey : monkeysForEnclosure) {
                    sb.append("Name: ").append(monkey.getName()).append("\n")
                            .append("Sex: ").append(monkey.getSex()).append("\n")
                            .append("Favorite Food: ").append(monkey.getFavoriteFood()).append("\n");
                }
            }
        }
        return sb.toString();
    }

    /**
     * Return the monkey list housed in the given enclosure
     * @return the monkey list housed in the given enclosure
     */
    public String monkeyListForGivenEnclosure(Species species) {
        StringBuilder sb = new StringBuilder();
        for (Enclosures enclosure: enclosures) {
            List<Monkey> monkeysForGivenEnclosure = null;
            if (enclosure.getSpecies() == species) {
                monkeysForGivenEnclosure = enclosure.getMonkeys();
                monkeysForGivenEnclosure.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
                sb.append("\nEnclosure - ").append(species).append(":\n");
                if (monkeysForGivenEnclosure.size() < 1) {
                    sb.append("There is no monkey in this enclosure space.\n");
                } else {
                    for (Monkey monkey : monkeysForGivenEnclosure) {
                        sb.append("Name: ").append(monkey.getName()).append("\n")
                                .append("Sex: ").append(monkey.getSex()).append("\n")
                                .append("Favorite Food: ").append(monkey.getFavoriteFood()).append("\n");
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * Return all the monkeys housed in the sanctuary in alphabetical order.
     * @return all the monkeys housed in the sanctuary in alphabetical order.
     */
    public String monkeyList() {
        StringBuilder sb = new StringBuilder();
        monkeys.sort(new Comparator<Monkey>() {
            @Override
            public int compare(Monkey o1, Monkey o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        sb.append("\nAll the monkeys in the sanctuary: \n");
        for (Monkey monkey: monkeys) {
            sb.append("Name: ").append(monkey.getName()).append("\n")
                    .append("Sex: ").append(monkey.getSex()).append("\n")
                    .append("Favorite Food: ").append(monkey.getFavoriteFood()).append("\n");
        }
        return sb.toString();
    }
}
