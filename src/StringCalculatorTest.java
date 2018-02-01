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

    @Test
    void testAddTwo() {
        StringCalculator calc = new StringCalculatorImpl();

        //positive positive
        int sum = calc.add("3,4");
        assertEquals(7, sum, "Expected: 7 Actual: " + sum);
        sum = calc.add("3\n4");
        assertEquals(7, sum, "Expected: 7 Actual: " + sum);

        //positive zero
        sum = calc.add("5,0");
        assertEquals(5, sum, "Expected: 5 Actual: " + sum);
        sum = calc.add("5\n0");
        assertEquals(5, sum, "Expected: 5 Actual: " + sum);

        //positive negative
        sum = calc.add("5,-3");
        assertEquals(2, sum, "Expected: 2 Actual: " + sum);
        sum = calc.add("5\n-3");
        assertEquals(2, sum, "Expected: 2 Actual: " + sum);

        //zero positive
        sum = calc.add("0,5");
        assertEquals(5, sum, "Expected: 5 Actual: " + sum);
        sum = calc.add("0\n5");
        assertEquals(5, sum, "Expected: 5 Actual: " + sum);

        //zero zero
        sum = calc.add("0,0");
        assertEquals(0, sum, "Expected: 0 Actual: " + sum);
        sum = calc.add("0\n0");
        assertEquals(0, sum, "Expected: 0 Actual: " + sum);

        //zero negative
        sum = calc.add("0,-2");
        assertEquals(-2, sum, "Expected: -2 Actual: " + sum);
        sum = calc.add("0\n-2");
        assertEquals(-2, sum, "Expected: -2 Actual: " + sum);

        //negative positive
        sum = calc.add("-5,23");
        assertEquals(18, sum, "Expected: 18 Actual: " + sum);
        sum = calc.add("-5\n23");
        assertEquals(18, sum, "Expected: 18 Actual: " + sum);

        //negative zero
        sum = calc.add("-5,0");
        assertEquals(-5, sum, "Expected: -5 Actual: " + sum);
        sum = calc.add("-5\n0");
        assertEquals(-5, sum, "Expected: -5 Actual: " + sum);

        //negative negative
        sum = calc.add("-2,-34");
        assertEquals(-36, sum, "Expected: -36 Actual:" + sum);
        sum = calc.add("-2\n-34");
        assertEquals(-36, sum, "Expected: -36 Actual:" + sum);
    }

    @Test
    void testAddN() {
        StringCalculator calc = new StringCalculatorImpl();

        //all positive
        int sum = calc.add("1,2,3,4");
        assertEquals(10, sum, "Expected: 10 Actual: " + sum);
        sum = calc.add("1\n2,3,4");
        assertEquals(10, sum, "Expected: 10 Actual: " + sum);
        sum = calc.add("1\n2\n3,4");
        assertEquals(10, sum, "Expected: 10 Actual: " + sum);
        sum = calc.add("1\n2\n3\n4");
        assertEquals(10, sum, "Expected: 10 Actual: " + sum);
        sum = calc.add("1\n2,3\n4");
        assertEquals(10, sum, "Expected: 10 Actual: " + sum);
        sum = calc.add("1,2\n3,4");
        assertEquals(10, sum, "Expected: 10 Actual: " + sum);
        sum = calc.add("1,2\n3\n4");
        assertEquals(10, sum, "Expected: 10 Actual: " + sum);
        sum = calc.add("1,2,3\n4");
        assertEquals(10, sum, "Expected: 10 Actual: " + sum);

        //all negative
        sum = calc.add("-1,-2,-3,-4,-5");
        assertEquals(-15, sum, "Expected: -10 Actual: " + sum);

        //mix
        sum = calc.add("-1,2,3,-4");
        assertEquals(0, sum, "Expected: 00 Actual: " + sum);
    }
    @Test
    void testAddNegative(){
        StringCalculator calc = new StringCalculatorImpl();
        // test negative numbers
        int sum = calc.add("-1, -5");
        assertEquals(-6, sum, "Expected: -6 Actual:" + sum);
        sum = calc.add("-1, -3, -5");
        assertEquals(-9, sum, "Expected: -9 Actual:" + sum);
        sum = calc.add("-1, 3, -5");
        assertEquals(-3, sum, "Expected: -3 Actual:" + sum);
    }
    @Test
    void testBadInput() {
        StringCalculator calc = new StringCalculatorImpl();

        assertThrows(NumberFormatException.class, () -> calc.add("1,"));
        assertThrows(NumberFormatException.class, () -> calc.add("1,\n2"));
        assertThrows(NumberFormatException.class, () -> calc.add("1,2\n"));
    }
}