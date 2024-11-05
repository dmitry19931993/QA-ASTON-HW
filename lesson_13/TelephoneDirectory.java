package lesson_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    private Map<String, List<String>> phoneBook;

    public TelephoneDirectory() {
        phoneBook = new HashMap<>();
    }


    public void add(String lastName, String phone) {
        if (!phoneBook.containsKey(lastName)) {
            phoneBook.put(lastName, new ArrayList<>());
        }
        phoneBook.get(lastName).add(phone);
    }

    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, new ArrayList<>());
    }

    public static void main(String[] args) {

        TelephoneDirectory directory = new TelephoneDirectory();

        directory.add("Журавлев", "+375336319845");
        directory.add("Мельник", "+375336319837");
        directory.add("Иванов", "+375336319896");
        directory.add("Мельник", "+375336319810");
        directory.add("Журавлев", "+375336319635");

        System.out.println("Телефоны Иванова: " + directory.get("Иванов"));
        System.out.println("Телефоны Журавлева: " + directory.get("Журавлев"));
        System.out.println("Телефоны Мельника: " + directory.get("Мельник"));
    }
}
