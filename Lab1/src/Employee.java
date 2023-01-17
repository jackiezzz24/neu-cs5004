/**
 * This class represent an Employee. The Employee has a name, an employee ID,
 * the number of worked hours and pay rate.
 */

public class Employee {
  public String name;
  public String employeeId;
  public double hours;
  private double rate;

  /**
   * Constructs an Employee object and initializes it to the given name, employee ID, the number of
   * hours worked and pay rate.
   *
   * @param name the name of this employee
   * @param employeeId the employee ID of this employee
   * @param hours the number of hours worked of this employee
   * @param rate the pay rate of this employee
   */

  public Employee(String name, String employeeId, double hours, double rate) {
    this.name = name;
    this.employeeId = employeeId;
    this.hours = 0;
    this.rate = rate;
  }

  /**
   * Add the hours worked for the employee
   * @param hours hours worked in this week
   */
  public void addHoursWorked(Double hours) {
    this.hours += hours;
    if (this.hours < 0) {
      this.hours = 0;
      System.out.println("Total number of hours worked cannot below zero.");
    }
  }

  /**
   * Reset the hours worked to zero
   */
  public void resetHoursWorked() {
    this.hours = 0;
  }

  /**
   * Return the hours worked for this week.
   *
   * @return the hours worked for this week.
   */

  public double getHoursWorked() {
    return this.hours;
  }

  /**
   * Return weekly pay for the employee
   *
   * @return weekly pay for the employee
   */

  public Double getWeeklyCheck() {
    PayCheck payCheck = new PayCheck(hours, rate);
    Double pay = Double.valueOf(Math.round(payCheck.getPayAfterTaxes()*100)/100);
    return pay;
  }

  /**
   * Return string about employee's name, id and payment after taxes
   *
   * @return string about employee's name, id and payment after taxes
   */
  public String toString() {
    PayCheck payCheck = new PayCheck(hours, rate);
    return "Name: " + this.name + "\n"
            + "ID: " + this.employeeId + "\n"
            + "Payment after taxes: " + payCheck.getPayAfterTaxes();
  }
}
