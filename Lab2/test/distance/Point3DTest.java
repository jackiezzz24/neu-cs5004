package distance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A JUnit test class for the Point3D class.
 */
class Point3DTest {

  private Point3D p1;
  private Point3D p2;
  @BeforeEach
  void setUp() {
    p1 = new Point3D(5, 2, 10);
    p2 = new Point3D(3, 4, 5);
  }

  @Test
  void getX() {
    Assertions.assertEquals(5, p1.getX(), 0.01);
  }

  @Test
  void getY() {
    Assertions.assertEquals(2, p1.getY(), 0.01);
  }

  @Test
  void getZ() {
    Assertions.assertEquals(10, p1.getZ(), 0.01);
  }

  @Test
  void distanceTo() {
    Assertions.assertEquals(5.745, p1.distanceTo(p2), 0.01);
  }

  @Test
  void testEquals() {
    Assertions.assertEquals(true, p1.equals(p1));
    Assertions.assertEquals(false, p1.equals(p2));

  }

  @Test
  void testHashCode() {
  }
}