package bank;

public abstract class Account implements IAccount {

  protected double balance;
  protected int times;
  protected double penalty;
  protected boolean lessThen100;


  /**
   * Constructs an account object and initializes it to the given starter amount.
   *
   * @param starter starter amount for this saving account
   * @throws IllegalArgumentException throw exception if starter amount less than 1 cent.
   */
  public Account(double starter) throws IllegalArgumentException {

    if (starter < 0.01) {
      throw new IllegalArgumentException("Starter amount cannot be less than one cent ($0.01)");
    }
    balance = starter;
    if (balance < 100) {
      lessThen100 = true;
    }
  }

  /**
   * Store the deposit amount into this saving account balance.
   *
   * @param amount deposit amount for this saving account.
   * @throws IllegalArgumentException throw an exception if the deposit amount less than 0.
   */
  @Override
  public void deposit(double amount) throws IllegalArgumentException {

    if (amount < 0) {
      throw new IllegalArgumentException("Deposit amount cannot be negative.");
    }

    balance += amount;

  }

  /**
   * Return true if withdraw success and return false if withdraw fails.
   *
   * @param amount withdraw amount for this saving account
   * @return true if withdraw success (balance more than withdraw amount) and
   * return false if withdraw fails (balance less than withdraw amount).
   * @throws IllegalArgumentException throw an exception if withdraw amount less than zero.
   */
  @Override
  public boolean withdraw(double amount) {

    if (amount < 0) {
      return false;
    }

    if (balance < amount) {
      return false;
    } else {
      times += 1;
      balance -= amount;
      if (balance < 100) {
        lessThen100 = true;
      }
      return true;
    }
  }

  /**
   * Return the balance of this saving account.
   *
   * @return the balance of this saving account.
   */
  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public void performMonthlyMaintenance() {
    balance -= penalty;
    times = 0;
  }

  /**
   * Return the string for the balance of this account.
   *
   * @return the string for the balance of this account
   */
  @Override
  public String toString() {
    return String.format("$%.2f", balance);
  }
}
