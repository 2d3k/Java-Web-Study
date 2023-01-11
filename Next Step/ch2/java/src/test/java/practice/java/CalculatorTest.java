package practice.java;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    // Junit
    @Test
    public void add() {
        System.out.println(calculator.add(6, 3));
    }

    @Test
    public void subtract() {
        System.out.println(calculator.subtract(6,3));
    }

    // assetEquals()
    @Test
    public void multiply() {
        assertEquals(9, calculator.multiply(3, 3));
    }

    @Test
    public void divide() {
        assertEquals(2, calculator.divide(6,3));
    }

}
