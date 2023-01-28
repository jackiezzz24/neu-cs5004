package bank;

/**
 * This class represent a saving account. The saving account has a balance amount.
 */
public class SavingsAccount extends Account {


  /**
   * Constructs a saving account object and initializes it to the given starter amount.
   *
   * @param starter starter amount for this saving account
   * @throws IllegalArgumentException throw exception if starter amount less than 1 cent.
   */
  public SavingsAccount(double starter) throws IllegalArgumentException {
    super(starter);
  }

  @Override
  public boolean withdraw(double amount) {
    if (amount < 0) {
      return false;
    }
    if (balance < amount) {
      return false;
    }
    times += 1;
    balance -= amount;
    if(times > 6) {
      penalty += 14;
    }
    return true;
  }
}
