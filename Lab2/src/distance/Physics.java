package distance;

public class Physics {

  public static double velocity(Point3D one, Point3D two, double elapsedTime)
          throws IllegalArgumentException{
    if (elapsedTime == 0 || elapsedTime < 0) {
      throw new IllegalArgumentException("Time value cannot be zero or negative");
    }
    return one.distanceTo(two) / elapsedTime;
  }
}
