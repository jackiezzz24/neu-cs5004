import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A JUnit test class for the Employee class.
 */

class EmployeeTest {

  private Employee clark;

  @BeforeEach
  void setUp() {
    clark = new Employee("Clark Kent", "SUPS-111", 0, 30);
  }

  @Test
  void addHoursWorked() {
    Double hourBefore = clark.hours;
    clark.addHoursWorked(20.0);
    Double hourAfter = clark.hours;
    assert hourAfter - hourBefore - 20.0 < 1e-6;
  }

  @Test
  void resetHoursWorked() {
    Double hourBefore = clark.hours;
    clark.addHoursWorked(20.0);
    clark.resetHoursWorked();
    Double hourAfter = clark.hours;
    assert hourAfter - hourBefore == 0.0;
  }

  @Test
  void getHoursWorked() {
    clark.addHoursWorked(20.0);
    assertEquals(20.0, clark.getHoursWorked());
  }

  @Test
  void getWeeklyCheck() {
    clark.addHoursWorked(10.0);
    assertEquals(270.0, clark.getWeeklyCheck());
  }

  @Test
  void testToString() {
  }
}