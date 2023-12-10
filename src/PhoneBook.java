//  Реализуйте структуру телефонной книги с помощью HashMap.
//  Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
//  их необходимо считать, как одного человека с разными телефонами.
//  Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иванов", "123");
        addContact(phoneBook, "Петров", "124");
        addContact(phoneBook, "Сидоров", "125");
        addContact(phoneBook, "Сидоров", "125");
        addContact(phoneBook, "Сидоров", "125");
        addContact(phoneBook, "Сидоров", "125");
        addContact(phoneBook, "Иванов", "126");
        addContact(phoneBook, "Петров", "127");
        addContact(phoneBook, "Петров", "128");

        System.out.println(sortByListLength(phoneBook));

    }
    public static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        }
        else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }
    public static Map<String, List<String>> sortByListLength(Map<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> numberPhone = new ArrayList<>(phoneBook.entrySet());

        for (int i = 0; i < numberPhone.size() - 1; i++) {
            for (int j = 0; j < numberPhone.size() - 1 - i; j++) {
                int length1 = numberPhone.get(j).getValue().size();
                int length2 = numberPhone.get(j+1).getValue().size();
                if (length1 < length2) {
                    Map.Entry<String, List<String>> temp = numberPhone.get(j);
                    numberPhone.set(j, numberPhone.get(j + 1));
                    numberPhone.set(j + 1, temp);
                }
            }
        }
        Map<String, List<String>> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> entry : numberPhone) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}

