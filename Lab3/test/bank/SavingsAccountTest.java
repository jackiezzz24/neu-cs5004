package bank;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

  private SavingsAccount s1;

  @BeforeEach
  void setUp() {
    s1 = new SavingsAccount(100);
  }

  @Test
  void withdraw() {
    for (int i = 0; i < 7; i++) {
      s1.withdraw(2);
    }
    assertEquals("$86.00", s1.toString());
    assertEquals(7,s1.times);
    assertEquals(14,s1.penalty);
  }
}