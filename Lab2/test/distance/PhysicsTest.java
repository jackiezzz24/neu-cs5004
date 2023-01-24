package distance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A JUnit test class for the physics class.
 */
class PhysicsTest {

  @Test
  void velocity() {
    Point3D p1 = new Point3D(5, 2, 10);
    Point3D p2 = new Point3D(3, 4, 5);
    Assertions.assertEquals(1.149, Physics.velocity(p1, p2, 5), 0.01);
  }
}