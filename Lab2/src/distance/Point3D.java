package distance;

import java.util.Objects;

/**
 * This class represent a 3D point. The 3D vector has x, y, and z.
 */
public class Point3D {
  private final double x;
  private final double y;
  private final double z;

  /**
   * Constructs a default 3D point object
   */
  public Point3D() {
    this (0, 0, 0);
  }

  /**
   * Constructs a 3D point object and initializes it to the given x, y, and z.
   *
   * @param x x of this 3D point
   * @param y y of this 3D point
   * @param z z of this 3D point
   */
  public Point3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Return x of this 3D point.
   *
   * @return x of this 3D point
   */
  public double getX() {
    return x;
  }

  /**
   * Return y of this 3D point.
   *
   * @return y of this 3D point
   */
  public double getY() {
    return y;
  }

  /**
   * Return y of this 3D point.
   *
   * @return y of this 3D point
   */
  public double getZ() {
    return z;
  }

  /**
   * Return the distance between the current point to another point.
   *
   * @param other Another 3D point
   * @return the distance between the current point to another point.
   */
  public double distanceTo(Point3D other) {
    return Math.sqrt((other.getX() - x) * (other.getX() - x) +
            (other.getY() - y) * (other.getY() - y) +
            (other.getZ() - z) * (other.getZ() - z));
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Point3D point3D) {
      return Objects.equals(this.getX(), point3D.getX()) &&
              Objects.equals(this.getY(), point3D.getY()) &&
              Objects.equals(this.getZ(), point3D.getZ());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, z);
  }
}
