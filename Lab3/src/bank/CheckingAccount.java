package bank;

/**
 * This class represent a checking account. The saving account has a balance amount.
 */

public class CheckingAccount extends Account {

  /**
   * Constructs a saving account object and initializes it to the given starter amount.
   *
   * @param starter starter amount for this saving account
   * @throws IllegalArgumentException throw exception if starter amount less than 1 cent.
   */
  public CheckingAccount(double starter) throws IllegalArgumentException {
    super(starter);
  }

  @Override
  public void performMonthlyMaintenance() {
    if (lessThen100) {
      balance -= 5;
      times = 0;
    }
  }
}
