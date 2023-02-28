//Given a class representing a Dog and the following methods

public class Dog {
    private String name;
    private boolean isMale;
    private int age;

    public Dog(String name, boolean isMale, int age) {
        if(name == null) {
            throw new IllegalArgumentException("must have name");
        }
        if(age <= 0) {
            throw new IllegalArgumentException("Must be born and not dead");
        }
        this.name = name;
        this.isMale = isMale;
        this.age = age;
    }

    public String getName()  { return name; }
    public boolean isMale()  { return isMale;}
    public int getAge()      { return age;  }
    public String toString() { return name; }
}
