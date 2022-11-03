
import io.qameta.allure.*;
import org.example.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Calculator Tests Epic")
public class CalculatorTest {

    @Test
    @Story("User tries to add 1 + 1 and the result to that operation should be 2")
    @Description("This method tests the adding of two numbers. For this example we are adding 1 + 1, which should be 2")
    @Severity(SeverityLevel.TRIVIAL)
    void addsTwoNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should be 2");
    }

    @Story("User tries to make several adds and the system fails on one")
    @Description("This method tests the adding of several operations but fails in one")
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,  1,  1",
            "1,  2,  3",
            "49,  51,  100",
            "1,  100,  101",
            "65,   45,   111"
    })
    void add(int first, int second, int expectedResult) {
        Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should be equal " + expectedResult);
    }
}
