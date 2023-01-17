import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * A JUnit test class for the Vector3D class.
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
  void testGetX() {
    assertEquals(5, v1.getX());
  }

  @Test
  void testGetY() {
    assertEquals(2, v1.getY());
  }

  @Test
  void testGetZ() {
    assertEquals(10, v1.getZ());
  }

  @Test
  void testToString() {
    assertEquals("(5.00, 2.00, 10.00)", v1.toString());
  }

  @Test
  void testGetMagnitude() {
    assertEquals(11.3578, v1.getMagnitude(),0.01);
  }

  @Test
  void testNormalizedVector() {
    assertEquals("(0.44, 0.18, 0.88)", v1.normalizedVector().toString());

    Exception ex = assertThrows(IllegalStateException.class, () -> v3.normalizedVector());
    String expectedMsg = "The magnitude cannot be zero.";
    assertEquals(expectedMsg, ex.getMessage());
  }

  @Test
  void testAddVector() {
    assertEquals("(8.00, 6.00, 15.00)", v1.addVector(v2).toString());
  }

  @Test
  void testMultiplyVector() {
    int constant = 3;
    assertEquals("(15.00, 6.00, 30.00)", v1.multiplyVector(constant).toString());
  }

  @Test
  void testDotProductVectors() {
    assertEquals(73, v1.dotProductVectors(v2) );
  }

  @Test
  void testAngleBetweenVectors() {
    assertEquals(24.638, v1.angleBetweenVectors(v2), 0.01);

    Exception ex = assertThrows(IllegalStateException.class, () -> v1.angleBetweenVectors(v3));
    String expectedMsg = "Either of magnitudes cannot be 0.";
    assertEquals(expectedMsg, ex.getMessage());
  }

  @Test
  void testCrossProductVectors() {
    assertEquals("(-30.00, 5.00, 14.00)", v1.crossProductVectors(v2).toString());
  }
}