package polynomial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit test class for the PolynomialImpl class.
 */
class PolynomialImplTest {

    private PolynomialImpl poly1;
    private PolynomialImpl poly2;
    private PolynomialImpl poly3;
    private PolynomialImpl poly4;
    private PolynomialImpl poly5;
    private PolynomialImpl poly6;

    @BeforeEach
    void setUp() {
        poly1 = new PolynomialImpl("5x^2 +4x^1 -2");
        poly2 = new PolynomialImpl("-5x^2 +7x^2 +3");
        poly3 = new PolynomialImpl("-10");
        poly4 = new PolynomialImpl("");
        poly5 = new PolynomialImpl("-3x^4 -2x^5 -5 +11x^1");
        poly6 = new PolynomialImpl("-5x^2 +4x^3");
    }


    @Test
    void testConstructor() {
        assertEquals("0", new PolynomialImpl().toString());
        assertEquals("5x^2 +4x^1 -2", poly1.toString());
        assertEquals("2x^2 +3", poly2.toString());
        assertEquals("-10", poly3.toString());
        assertEquals("0", poly4.toString());
        assertThrows(IllegalArgumentException.class, () -> {new PolynomialImpl("-3x^4-2x^5");});

    }

    @Test
    void testToString() {
        assertEquals("-2x^5 -3x^4 +11x^1 -5", poly5.toString());
        assertEquals("4x^3 -5x^2", poly6.toString());
    }

    @Test
    void add() {
        assertEquals("-2x^5 -3x^4 +4x^3 -5x^2 +11x^1 -5", poly5.add(poly6).toString());
        assertEquals("4x^3 +4x^1 -2", poly1.add(poly6).toString());
        assertEquals("4x^3 -5x^2 -10", poly3.add(poly6).toString());
        assertThrows(IllegalArgumentException.class, () -> {new PolynomialImpl("-3x^4-2x^5");});
    }

    @Test
    void addTerm() {
        assertThrows(IllegalArgumentException.class, () -> {poly1.addTerm(2, -1);});
        poly1.addTerm(4, 1);
        assertEquals("5x^2 +8x^1 -2", poly1.toString());
        poly1.addTerm(2, 3);
        assertEquals("2x^3 +5x^2 +8x^1 -2", poly1.toString());
        poly5.addTerm(-2, 3);
        assertEquals("-2x^5 -3x^4 -2x^3 +11x^1 -5", poly5.toString());
        poly5.addTerm(0, 3);
        assertEquals("-2x^5 -3x^4 -2x^3 +11x^1 -5", poly5.toString());
        poly5.addTerm(4, 0);
        assertEquals("-2x^5 -3x^4 -2x^3 +11x^1 -1", poly5.toString());
    }

    @Test
    void isSame() {
        PolynomialImpl test1 = new PolynomialImpl("-5x^2 +7x^2 +3");
        PolynomialImpl test2 = new PolynomialImpl("2x^2 +3");
        PolynomialImpl test3 = new PolynomialImpl("2x^2");
        assertTrue(poly2.isSame(test1));
        assertTrue(poly2.isSame(test2));
        assertFalse(poly2.isSame(test3));
    }

    @Test
    void evaluate() {
        assertEquals(10, poly1.evaluate(-2));
        assertEquals(26, poly1.evaluate(2));
        assertEquals(-10, poly3.evaluate(2));
        assertEquals(0, poly4.evaluate(2));
    }

    @Test
    void getCoefficient() {
        assertEquals(2, poly2.getCoefficient(2));
        assertEquals(0, poly2.getCoefficient(3));
        assertEquals(-10, poly3.getCoefficient(0));
        assertEquals(0, poly4.getCoefficient(1));
    }

    @Test
    void getDegree() {
        assertEquals(0, poly3.getDegree());
        assertEquals(5, poly5.getDegree());
    }


}