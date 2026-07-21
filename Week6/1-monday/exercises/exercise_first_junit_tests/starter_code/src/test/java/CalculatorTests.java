import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.management.DescriptorKey;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {

    private Calculator calculator;

    // arrange data before each test
    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Two positive number addition ")
    void add_twoPositiveNumbers_returnsSum(){
        int result = calculator.add(5, 3);
        assertEquals(8, result, "5 + 3 should = 8");
    }

    @Test
    @DisplayName("Positive and negative number addition")
    void add_positiveNegativeAddition_returnsSum(){
        int result = calculator.add(10, -3);
        assertEquals(7, result, "10 + -3 shou;d equal 7");
    }

    @Test
    @DisplayName("Two negative number addition")
    void add_twoNegativeNumbers_returnsSum(){
        int result = calculator.add(-5, -3);
        assertEquals(-8, result, "-5 + -3 = -8;  should equal -8");
    }

    @Test
    @DisplayName("Adding zero")
    void add_valuePlusZero_returnsSum(){
        int result = calculator.add(42, 0);
        assertEquals(42, result, "42 + 0 = 42; add() should equal 42");
    }

    @Test
    @DisplayName("Basic Subtraction (Positive result)")
    void subtract_basicSubtractionPositive_returnsPositive(){
        int result = calculator.subtract(10, 2);
        assertEquals(8, result, "10 - 2 = 8; sub() should return 8");
    }

    @Test
    @DisplayName("Basic Subtraction (Negative result)")
    void subtract_basicSubtractionNegative_returnsNegative(){
        int result = calculator.subtract(1, 10);
        assertEquals(-9, result, "1 - 10 = -9; sub() should return -9");
    }

    @Test
    @DisplayName("Basic Subtraction (Subtracting Zero)")
    void subtract_basicSubtractionZero_returnsSame(){
        int result = calculator.subtract(10, 0);
        assertEquals(10, result, "10 - 0 = 10; sub() should return 10");
    }

    @Test
    @DisplayName("isEven() - positive numbers")
    void isEven_positiveNumbers_returnTrue(){
        int positiveEvenNumber = 2;
        boolean isTrue = calculator.isEven(positiveEvenNumber);
        assertTrue(isTrue, "2 is even; isEven should return true");
    }

    @Test
    @DisplayName("isEven() - odd numbers")
    void isEven_positiveOddNumbers_throwsArithmeticError(){
        int oddPositiveNumber = 1;
        boolean isFalse = calculator.isEven(oddPositiveNumber);
        assertFalse(isFalse, "1 is even; isEven() should therefore return true");
    }

    @Test
    @DisplayName("isEven() - zero")
    void isEven_zero_returnTrue(){
        int zero = 0;
        boolean isTrue = calculator.isEven(zero);
        assertTrue(isTrue, "0 mod 10 == 0; isEven() therefore should return true");
    }

    @Test
    @DisplayName("isEven - negative odd number")
    void isEven_negativeOddNumber_returnFalse(){
        int negativeOddNumber = -1;
        boolean isFalse = calculator.isEven(negativeOddNumber);
        assertFalse(isFalse, "-1 is not even; isEven() should return false");
    }

    @Test
    @DisplayName("isEven - negative even number")
    void isEven_negativeEvenNumber_returnTrue(){
        int negativeEvenNumber = -2;
        boolean isTrue = calculator.isEven(negativeEvenNumber);
        assertTrue(isTrue, "-2 is even; isEven() should return true");
    }

    
}
