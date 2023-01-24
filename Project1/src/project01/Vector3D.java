package project01;

/**
 * This class represent a 3D vector. The 3D vector has x, y, and z.
 */
public class Vector3D {
  private final double x;
  private final double y;
  private final double z;

  /**
   * Constructs a 3D vector object and initializes it to the given x, y, and z.
   *
   * @param x x of this 3D vector
   * @param y y of this 3D vector
   * @param z z of this 3D vector
   */
  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Return x of this 3D vector.
   *
   * @return x of this 3D vector
   */
  public double getX() {
    return x;
  }

  /**
   * Return y of this 3D vector.
   *
   * @return y of this 3D vector
   */
  public double getY() {
    return y;
  }

  /**
   * Return z of this 3D vector.
   *
   * @return z of this 3D vector
   */
  public double getZ() {
    return z;
  }

  /**
   * Return a string to describe this vector.
   *
   * @return a string to describe this vector
   */
  public String toString() {
    return String.format("(%.2f, %.2f, %.2f)", x, y, z);
  }

  /**
   * Return the magnitude of this vector.
   *
   * @return the magnitude of this vector
   */
  public Double getMagnitude () {
    double mag;
    mag = Math.sqrt(x * x + y * y + z * z);
    return mag;
  }

  /**
   * Return a normalized version of this vector.
   *
   * @return a normalized version of this vector
   * @throws IllegalArgumentException if magnitude of vector is zero
   */
  public Vector3D normalize () throws IllegalStateException {
    if (getMagnitude() == 0) {
      throw new IllegalStateException("The magnitude cannot be zero.");
    }
    double normX = x / getMagnitude();
    double normY = y / getMagnitude();
    double normZ = z / getMagnitude();
    return new Vector3D(normX, normY, normZ);
  }

  /**
   * Return the result of adding this vector to another vector.
   *
   * @param vector3D The another vector
   * @return the result of adding this vector to another vector
   */
  public Vector3D add (Vector3D vector3D) {
    return new Vector3D(x + vector3D.getX(),
                        y + vector3D.getY(),
                        z + vector3D.getZ());
  }

  /**
   * Return the result of multiplying this vector by a constant.
   *
   * @param constant The multiplying constant
   * @return the result of multiplying this vector by a constant
   */
  public Vector3D multiply (double constant) {
    return new Vector3D(x * constant,
                        y * constant,
                        z * constant);
  }

  /**
   * Return the dot product of two vectors.
   *
   * @param vector3D The another Vector
   * @return the dot product of two vectors
   */
  public double dotProduct (Vector3D vector3D) {
    return x * vector3D.getX()
            + y * vector3D.getY()
            + z * vector3D.getZ();
  }

  /**
   * Return the angle between two vectors in degree.
   *
   * @param vector3D The another vector
   * @return the angle between two vectors in degree
   * @throws IllegalStateException if the magnitude of either vector is zero
   */
  public double angleBetween (Vector3D vector3D) throws IllegalStateException {
    if (getMagnitude() == 0 || vector3D.getMagnitude() == 0) {
      throw new IllegalStateException("Either of magnitudes cannot be 0.");
    }
    double cosVector = dotProduct(vector3D) / (getMagnitude() * vector3D.getMagnitude());
    return Math.toDegrees(Math.acos(cosVector));
  }

  /**
   * Return the cross product of this vector and another vector.
   *
   * @param vector3D The another vector
   * @return the cross product of this vector and another vector
   */
  public Vector3D crossProduct (Vector3D vector3D) {
    double crossProductX = y * vector3D.getZ() - z * vector3D.getY();
    double crossProductY = z * vector3D.getX() - x * vector3D.getZ();
    double crossProductZ = x * vector3D.getY() - y * vector3D.getX();
    return new Vector3D(crossProductX, crossProductY, crossProductZ);
  }
}
