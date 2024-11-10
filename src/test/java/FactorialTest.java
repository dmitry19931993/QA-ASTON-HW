import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class FactorialTest {
    @DataProvider
    public Object[][] data() {
        return new Object[][] {
                {0, 1},
                {1, 1},
                {4, 24},
                {5, 20}
        };
    }

    @Test(dataProvider = "data")
    public void testFactorial(int input, int expected) {
        Factorial f = new Factorial();
        int result = f.factorial(input);
        Assert.assertEquals(result, expected);
    }
}