public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee(
                "Иванов Иван Иванович",
                "Менеджер",
                "ivanov@mail.com",
                "89001234567",
                50000,
                35
        );
        employees[1] = new Employee(
                "Сидоров Михаил Вячеславович",
                "Директор",
                "sidorov@mail.com",
                "89005673967",
                500000,
                40
        );
        employees[2] = new Employee(
                "Закревский Федор Дмитриевич",
                "Продавец",
                "zakr@mail.com",
                "89000948567",
                60000,
                30
        );
        employees[3] = new Employee(
                "Курочкина Инесса Михайловна",
                "Секретарь",
                "kur@mail.com",
                "8900980545567",
                40000,
                39
        );
        employees[4] = new Employee(
                "Бразевисч Инна Анатольевна",
                "Продавец",
                "brazevic@mail.com",
                "8900963584567",
                50000,
                32
        );
        for (Employee employee : employees) {
            employee.printInfo();
            System.out.println();
        }

        Park park = new Park();
        Park.Attraction attraction = park.new Attraction(
                "Американские горки", "10:00 - 18:00", 500
        );
        attraction.printInfo();
    }
}
