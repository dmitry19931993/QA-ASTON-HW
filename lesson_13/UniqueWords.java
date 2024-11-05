package lesson_13;

import java.util.*;

public class UniqueWords {
    public static void main(String[] args) {
        String[] words = {
                "коллекция", "библиотека", "функция", "парадигма", "библиотека", "алгоритм",
                "функция", "код", "отладка", "коллекция", "переменная", "архитектура", "функция",
                "исключения", "отладка", "парадигма", "функция", "операции", "архитектура"
        };

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Уникальные слова: " + wordCount.keySet());
        System.out.println("Количество каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
