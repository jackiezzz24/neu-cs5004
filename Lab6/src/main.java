import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class main {
  public static void main(String[] args) {
    List<Dog> dogs = new LinkedList<>();
    dogs.add(new Dog("Fifi", false, 22));
    dogs.add(new Dog("Fido", true, 10));
    dogs.add(new Dog("Fluffy", false, 11));
    dogs.add(new Dog("Louise", false, 5));
    dogs.add(new Dog("Coco", false, 7));
    dogs.add(new Dog("Rex", true, 3));

    Predicate<Dog> dp = (d) -> !d.isMale() && d.getAge() < 10;

    List<Dog> ourDogs = dogs.stream().filter(dp).collect(Collectors.toList());

  }
}

//What is the data type of the variable ourDogs?
//List<Dog>

//What is the size() of ourDogs, and what are the elements it contains?
//2. Louise and Coco

//Assume we change our predicate in the above example to:
//Predicate<Dog> dp = (d) -> d.isMale() && d.getAge() > 5;
//Now, what is the size() of ourDogs, and what are the elements it contains?
//1. Fido.