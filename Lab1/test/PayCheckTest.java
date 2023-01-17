import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayCheckTest {

  private PayCheck payCheck;

  @BeforeEach
  void setUp() {
    payCheck = new PayCheck(10.0, 30);
  }

  @Test
  void getTotalPay() {
    assertEquals(300.0, payCheck.getTotalPay());
  }

  @Test
  void getPayAfterTaxes() {
    assertEquals(270.0, payCheck.getPayAfterTaxes());
  }

  @Test
  void testToString() {

  }
}