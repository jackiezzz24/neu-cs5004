import distance.Physics;
import distance.Point3D;

public class main {
  public static void main(String[] args) {
    try {
      Point3D one = new Point3D();
      Point3D two = new Point3D(1, 1, 1);
      System.out.println("Displacement = " + one.distanceTo(two));
      double velocity = Physics.velocity(one, two, 5);
      System.out.println("Prof. Keith is on the move! His Velocity = " + velocity);
      velocity = Physics.velocity(one, two, 0);
      System.out.println("Velocity = " + velocity);
    } catch (IllegalArgumentException ex) {
      System.out.println("Encountered an error: " + ex.getMessage());
    }
  }

}
