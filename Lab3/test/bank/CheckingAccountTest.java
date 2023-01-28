package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {

  private CheckingAccount c1;
  private CheckingAccount c2;


  @BeforeEach
  void setUp() {
    c1 = new CheckingAccount(50);
    c2 = new CheckingAccount(200);
  }

  @Test
  void performMonthlyMaintenance() {
    c1.performMonthlyMaintenance();
    assertEquals("$45.00", c1.toString());
    assertEquals(0,c1.times);

    for (int i = 0; i < 10; i++) {
      c2.withdraw(15);
    }
    c2.performMonthlyMaintenance();
    assertEquals("$45.00", c2.toString());
    assertEquals(0,c2.times);
  }
}