public class Monkey {
    private String name;
    private Species species;
    private String designation;
    private Sex sex;
    private double size;
    private double weight;
    private int age;
    private Food favoriateFood;

    public Monkey(String name, Species species, String designation
            , Sex sex, double size, double weight, int age, Food favoriateFood) {
        this.name = name;
        this.species = species;
        this.designation = designation;
        this.sex = sex;
        this.size = size;
        this.weight = weight;
        this.age = age;
        this.favoriateFood = favoriateFood;
    }
}
