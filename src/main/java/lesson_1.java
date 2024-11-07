public class lesson_1 {

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 5, b = -10, sum;
        sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 50;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 10, b = 7;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Число " + number + " положительное");
        } else {
            System.out.println("Число " + number + " отрицательное");
        }
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void printString(String text, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }

    public static void invertArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        System.out.println("Массив инвертирован");
    }

    public static void createAndFillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println("\"Заполненный массив:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void multiplyLessThanSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        System.out.println("\nИзмененный массив:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void createDiagonalArray(int size) {
        int[][] array = new int[size][size];
        for (int i = 0; i < size; i++) {
            array[i][size - 1 - i] = 1;
            array[i][i] = 1;
        }
        System.out.println("Квадратный массив с единицами на диагоналях:");
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }


    public static void main(String[] args) {
        printThreeWords();
        System.out.println("----------------------------");
        checkSumSign();
        System.out.println("----------------------------");
        printColor();
        System.out.println("----------------------------");
        compareNumbers();
        System.out.println("----------------------------");
        System.out.println(isSumInRange(5, 6));
        System.out.println("----------------------------");
        checkNumber(0);
        System.out.println("----------------------------");
        System.out.println(isNegative(-3));
        System.out.println("----------------------------");
        printString("Hello, Aston!", 3);
        System.out.println("----------------------------");
        System.out.println(isLeapYear(2024));
        System.out.println("----------------------------");
        invertArray();
        System.out.println("----------------------------");
        createAndFillArray();
        System.out.println("----------------------------");
        multiplyLessThanSix();
        System.out.println("----------------------------");
        createDiagonalArray(6);
        System.out.println("----------------------------");
        int[] array = createArray(5, 10);
        System.out.println("Созданный массив:");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println("----------------------------");

    }
}