package model.monkey;

/**
 * This class represent a monkey. The monkey has a name, a species designation, a sex, a size,
 * a weight, an approximate age and a favorite food.
 */
public class Monkey {
    private final String name;
    private final Species species;
    private final Sex sex;
    private double size;
    private double weight;
    private int age;
    private Food favoriteFood;
    private boolean medicalAttention;

    /**
     * Constructs a model.monkey.Monkey object and initializes it to the given name, species designation, sex, size,
     * weight, approximate age and favorite food.
     * @param name The monkey's name
     * @param species The monkey's species
     * @param sex The monkey's sex
     * @param size The monkey's size
     * @param weight The monkey's weight
     * @param age The monkey's age
     * @param favoriteFood The monkey's favourite food
     * @throws IllegalArgumentException if name, species, sex and favorite food is null
     * or size, weight, age is negative.
     */

    public Monkey(String name, Species species, Sex sex, double size, double weight, int age, Food favoriteFood)
            throws IllegalArgumentException {
        if (name == null || species == null || sex == null
                || size <= 0 || weight <= 0 || age <= 0 || favoriteFood == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.weight = weight;
        this.age = age;
        this.favoriteFood = favoriteFood;
        this.medicalAttention = false;
    }

    /**
     * Return the name of the monkey
     * @return the name of the monkey
     */
    public String getName() {
        return name;
    }

    /**
     * Return the sex of the monkey
     * @return the sex of the monkey
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Return the favorite food of the monkey
     * @return the favorite food of the monkey
     */
    public Food getFavoriteFood() {
        return favoriteFood;
    }

    /**
     * Return true if the monkey received the medical attention. Otherwise, false.
     * @return true if the monkey received the medical attention. Otherwise, false.
     */

    public boolean isMedicalAttention() {
        return medicalAttention;
    }

    /**
     * Return the species of the monkey
     * @return the species of the monkey
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * Set to true if the monkey received the medical attention. Otherwise, false.
     * @param medicalAttention set to true if the monkey received the medical attention. Otherwise, false.
     */
    public void setMedicalAttention(boolean medicalAttention) {
        this.medicalAttention = medicalAttention;
    }

    /**
     * Return the string representation of the Monkey object.
     * @return the string representation of the Monkey object.
     */
    @Override
    public String toString(){
        return "Name: " + name + "\n"
                + "Species: " + species + "\n"
                + "Sex: " + sex + "\n"
                + "Size: " + size + "\n"
                + "Weight: " + weight + "\n"
                + "Age: " + age + "\n"
                + "Favorite Food: " + favoriteFood + "\n";
    }
}
