import static org.junit.jupiter.api.Assertions.*;

import org.example.Calculator;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void testSqrt() {
        assertEquals(4, calculator.sqrt(16));
    }

    @Test
    void testFactorial() {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    void testLn() {
        assertEquals(0, calculator.ln(1), 0.0001);
    }

    @Test
    void testPower() {
        assertEquals(8, calculator.power(2, 3));
    }
}
