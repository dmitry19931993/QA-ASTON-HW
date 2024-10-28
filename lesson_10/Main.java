package lesson_10;

class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = Math.max(foodAmount, 0);
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " единиц еды.");
            System.out.println("В миске осталось " + foodAmount + " единиц еды");
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды.");
            System.out.println("В миске осталось " + foodAmount + " единиц еды");
        }
    }

    public boolean decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class Animal {
    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    private static int animalCount = 0;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }

    public static int getAnimalCount() {
        return animalCount;
    }
}

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name, 500, 10);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name, 200, 0);
        this.isFull = false;
        catCount++;
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public static int getCatCount() {
        return catCount;
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (!isFull) {
            if (bowl.decreaseFood(foodAmount)) {
                isFull = true; // Кот поел, стал сытым
                System.out.println(name + " поел " + foodAmount + " единиц еды и теперь сыт.");
                System.out.println("В миске осталось " + bowl.getFoodAmount() + " единиц еды");
            } else {
                System.out.println(name + " не хватило еды, он остался голодным.");
                System.out.println("В миске осталось " + bowl.getFoodAmount() + " единиц еды");
            }
        } else {
            System.out.println(name + " уже сыт.");
        }
    }

    public boolean isFull() {
        return isFull;
    }
}

public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(25);

        Dog dogBobik = new Dog("Бобик");
        Cat[] cats = {
                new Cat("Мурзик"),
                new Cat("Барсик"),
                new Cat("Пушок"),
                new Cat("Снежок")
        };

        dogBobik.run(3000);
        System.out.println("-----------------------------");
        dogBobik.swim(5);
        System.out.println("-----------------------------");

        cats[0].run(100);
        System.out.println("-----------------------------");
        cats[1].swim(10);
        System.out.println("-----------------------------");

        for (Cat cat : cats) {
            cat.eat(bowl, 10);
        }
        System.out.println("-----------------------------");
        for (Cat cat : cats) {
            String satiety = cat.isFull() ? "сыт" : "голоден";
            System.out.println(cat.name + " " + satiety);
        }
        System.out.println("-----------------------------");
        bowl.addFood(20);

        System.out.println("-----------------------------");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
        System.out.println("-----------------------------");

        Shape circle = new Circle(
                "Круг",5, "Красный", "Черный"
        );
        Shape rectangle = new Rectangle(
                "Прямоугольник",4, 6, "Синий", "Зеленый"
        );
        Shape triangle = new Triangle(
                "Трехугольник",3, 4, 5, "Желтый", "Коричневый"
        );

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}
