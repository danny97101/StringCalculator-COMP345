import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void testAddEmpty() {
        StringCalculator calc = new StringCalculatorImpl();

        int sum = calc.add("");
        assertEquals(0, sum, "Expected: 0 Actual: " + sum);
    }

    @Test
    void testAddOne() {
        StringCalculator calc = new StringCalculatorImpl();

        //positive
        int sum = calc.add("7");
        assertEquals(7, sum, "Expected: 7 Actual: " + sum);

        //zero
        sum = calc.add("0");
        assertEquals(0, sum, "Expected: 0 Actual: " + sum);

        //negative
        sum = calc.add("-8");
        assertEquals(-8, sum, "Expected: -8 Actual: " + sum);

        //multiple digits
        sum = calc.add("123");
        assertEquals(123, sum, "Expected: 123 Actual: " + sum);

        //bad format
        assertThrows(NumberFormatException.class, () -> calc.add("m"));
    }
}