package phonebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PhoneBook {

    private final List<Entry> phoneBook = new LinkedList<>();

    public void add(String name, String phone) {
        Entry entry = new Entry(name, phone);
        phoneBook.add(entry);
    }

    public Entry find(String name) {
        for (Entry entry : phoneBook) {
            if (name.equals(entry.getName())) {
                return entry;
            }
        }
        return null;
    }

    public List<Entry> findAll(String name) {
        List<Entry> entries = new ArrayList<>();
        for (Entry entry : phoneBook) {
            if (name.equals(entry.getName())) {
                entries.add(entry);
            }
        }
        return entries.isEmpty() ? null : entries;
    }
}
