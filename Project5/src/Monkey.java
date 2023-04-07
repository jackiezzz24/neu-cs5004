/**
 * This class represent a monkey. The monkey has a name, a species designation, a sex, a size,
 * a weight, an approximate age and a favorite food.
 */
public class Monkey {
    private String name;
    private Species species;
    private Sex sex;
    private double size;
    private double weight;
    private int age;
    private Food favoriteFood;
    private boolean medicalAttention;

    /**
     * Constructs a Monkey object and initializes it to the given name, species designation, sex, size,
     * weight, approximate age and favorite food.
     * @param name The monkey's name
     * @param species The monkey's species
     * @param sex The monkey's sex
     * @param size The monkey's size
     * @param weight The monkey's weight
     * @param age The monkey's age
     * @param favoriteFood The monkey's favourite food
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

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public Food getFavoriteFood() {
        return favoriteFood;
    }

    public boolean isMedicalAttention() {
        return medicalAttention;
    }

    public Species getSpecies() {
        return species;
    }

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
