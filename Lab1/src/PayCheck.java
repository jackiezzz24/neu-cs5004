/**
 * This class represents a paycheck. The paycheck has the number of hours worked and pay rate
 */
public class PayCheck {
  private final double hours;
  private final double rate;

  /**
   * Construct a paycheck object and initializes it to the given number of hours worked and pay rate.
   *
   * @param hours the number of hour worked
   * @param rate the pay rate
   */
  public PayCheck(double hours, double rate) {
    this.hours = hours;
    this.rate = rate;
  }

  /**
   * Return the total pay of the paycheck
   *
   * @return the total pay of the paycheck
   */
  public double getTotalPay() {
    double totalPay;
    if (hours <= 40) {
      totalPay = hours * rate;
    }
    else {
      totalPay = rate * 40 + rate * 1.5 * (hours - 40);
    }
    return totalPay;
  }

  /**
   * Return the total pay after taxes
   *
   * @return the total pay after taxes
   */
  public double getPayAfterTaxes() {
    double payAfterTax;
    double totalPay = getTotalPay();
    if (totalPay < 400) {
      payAfterTax = totalPay * (1 - 0.1);
    }
    else {
      payAfterTax = totalPay * (1 - 0.15);
    }
    return payAfterTax;
  }

  /**
   * Return the string of the paycheck with payment after taxes
   *
   * @return the string of the paycheck with the payment after taxes
   */
  public String toString() {
    return "Payment after taxes: $" +
            getPayAfterTaxes();
  }
}
