import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project01.Vector3D;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit test class for the project1.Vector3D class.
 */
class Vector3DTest {

  private Vector3D v1;
  private Vector3D v2;
  private Vector3D v3;

  @BeforeEach
  void setUp() {
    v1 = new Vector3D(5, 2, 10);
    v2 = new Vector3D(3, 4, 5);
    v3 = new Vector3D(0, 0, 0);
  }

  @Test
  void getX() {
    assertEquals(5, v1.getX());
  }

  @Test
  void getY() {
    assertEquals(2, v1.getY());
  }

  @Test
  void getZ() {
    assertEquals(10, v1.getZ());
  }

  @Test
  void testToString() {
    assertEquals("(5.00, 2.00, 10.00)", v1.toString());
  }

  @Test
  void getMagnitude() {
    assertEquals(11.3578, v1.getMagnitude(),0.01);
  }

  @Test
  void normalize() {
    assertEquals("(0.44, 0.18, 0.88)", v1.normalize().toString());

    Exception ex = assertThrows(IllegalStateException.class, () -> v3.normalize());
    String expectedMsg = "The magnitude cannot be zero.";
    assertEquals(expectedMsg, ex.getMessage());
  }

  @Test
  void add() {
    assertEquals("(8.00, 6.00, 15.00)", v1.add(v2).toString());
  }

  @Test
  void multiply() {
    double constant = 3;
    assertEquals("(15.00, 6.00, 30.00)", v1.multiply(constant).toString());
  }

  @Test
  void dotProduct() {
    assertEquals(73, v1.dotProduct (v2) );
  }

  @Test
  void angleBetween() {
    assertEquals(24.638, v1.angleBetween(v2), 0.01);

    Exception ex = assertThrows(IllegalStateException.class, () -> v1.angleBetween(v3));
    String expectedMsg = "Either of magnitudes cannot be 0.";
    assertEquals(expectedMsg, ex.getMessage());
  }

  @Test
  void crossProduct() {
    assertEquals("(-30.00, 5.00, 14.00)", v1.crossProduct (v2).toString());
  }
}