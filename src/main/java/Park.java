public class Park {

    public class Attraction {
        private String name;
        private String working_hours;
        private double price;

        public Attraction(String name, String working_hours, double price) {
            this.name = name;
            this.working_hours = working_hours;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + working_hours);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println();
        }
    }
}
