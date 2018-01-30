import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @org.junit.jupiter.api.Test
    void testAddEmpty() {
        StringCalculator calc = new StringCalculatorImpl();

        int sum = calc.add("");
        assertEquals(0, sum, "Expected: 0 Actual: " + sum);
    }
}