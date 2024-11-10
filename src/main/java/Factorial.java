public class Factorial {

    public static int factorial(int n) {
        int m = 1;
        for (int i = 1; i <= n; i++) {
            m *= i;
        }
        return m;
    }

    public static void main(String [] args) {
        System.out.println(factorial(-1));
    }
}
