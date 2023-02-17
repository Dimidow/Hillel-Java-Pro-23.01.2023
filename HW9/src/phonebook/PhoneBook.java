package phonebook;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBook {

    private final List<Entry> phoneBook = new LinkedList<>();

    public void add(String name, String phone) {
        Entry entry = new Entry(name, phone);
        phoneBook.add(entry);
    }

    public Entry find(String name) {
        return phoneBook.stream()
                        .filter(entry -> name.equals(entry.getName()))
                        .findAny()
                        .orElse(null);
    }

    public List<Entry> findAll(String name) {
        if (find(name) == null) {return null;}
        return phoneBook.stream()
                        .filter(entry -> name.equals(entry.getName()))
                        .collect(Collectors.toList());
    }
}
