import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
    @ParameterizedTest
    @CsvSource({"0, 1","1, 1","2, 2", "5, 120", "4, 23"})

    public void testFactorial(int first, int second) {
        Factorial f = new Factorial();
        int result = f.factorial(first);
        assertEquals(second, result);
    }
}