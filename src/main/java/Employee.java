public class Employee {
    private String full_name;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;


    public Employee(
            String full_name, String position, String email,
            String phone, double salary, int age
    ) {
        this.full_name = full_name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Информация о сотруднике:");
        System.out.println("ФИО: " + full_name);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary + " руб.");
        System.out.println("Возраст: " + age + " лет");
    }
}
