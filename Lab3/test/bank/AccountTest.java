package bank;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

  private SavingsAccount s1;
  private SavingsAccount s2;
  private CheckingAccount c1;
  private CheckingAccount c2;


  @BeforeEach
  void setUp() {
    s2 = new SavingsAccount(150);
    c2 = new CheckingAccount(150);

  }

  @Test
  void testConstructor() {
    Exception ex1 = assertThrows(IllegalArgumentException.class, ()
            -> s1 = new SavingsAccount(0));
    String expMsg1 = "Starter amount cannot be less than one cent ($0.01)";
    assertEquals(expMsg1, ex1.getMessage());

    Exception ex2 = assertThrows(IllegalArgumentException.class, ()
            -> c1 = new CheckingAccount(0));
    String expMsg2 = "Starter amount cannot be less than one cent ($0.01)";
    assertEquals(expMsg2, ex2.getMessage());
  }

  @Test
  void deposit() {
    Exception ex1 = assertThrows(IllegalArgumentException.class, ()
            -> s2.deposit(-1));
    String expMsg1 = "Deposit amount cannot be negative.";
    assertEquals(expMsg1, ex1.getMessage());

    Exception ex2 = assertThrows(IllegalArgumentException.class, ()
            -> c2.deposit(-1));
    String expMsg2 = "Deposit amount cannot be negative.";
    assertEquals(expMsg2, ex2.getMessage());

    s2.deposit(50);
    assertEquals("$200.00", s2.toString());

    c2.deposit(50);
    assertEquals("$200.00", c2.toString());

  }

  @Test
  void withdraw() {
    assertFalse(s2.withdraw(-1));
    assertFalse(c2.withdraw(-1));

    assertFalse(s2.withdraw(300));
    assertFalse(c2.withdraw(300));

    s2.withdraw(50);
    assertEquals("$100.00", s2.toString());

    c2.withdraw(70);
    assertEquals("$80.00", c2.toString());

  }

  @Test
  void getBalance() {
    assertEquals("$150.00", s2.toString());
    assertEquals("$150.00", c2.toString());
  }

  @Test
  void performMonthlyMaintenance() {
    SavingsAccount s3 = new SavingsAccount(100);
    for (int i = 0; i < 7; i++) {
      s3.withdraw(2);
    }
    s3.performMonthlyMaintenance();
    assertEquals("$72.00", s3.toString());
    assertEquals(0,s3.times);
  }

  @Test
  void testToString() {
    assertEquals("$150.00", s2.toString());
    assertEquals("$150.00", c2.toString());
  }
}