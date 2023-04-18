import controller.Controller;
import model.housing.Sanctuary;

public class Main {
    public static void main(String[] args) {
        Sanctuary sanctuary = new Sanctuary();
        Controller controller = new Controller(sanctuary);
    }
}