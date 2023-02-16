import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import phonebook.PhoneBook;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> sourceList = new ArrayList<>(Arrays.asList(
            "Створити", "метод", "countOccurance", "що", "приймає", "на", "рядковий", "список",
            "як", "параметр", "і", "java", "довільний рядок", "довільний рядок"
        ));
        String argsForMatch = "довільний рядок";

        int[] targetArray = {1, 4, 7, 13, 2, 17, 87, 43, 2, 2, 13};

        List<String> calcOccuranceList = new ArrayList<>(Arrays.asList("bird", "fox", "cat", "bird"));


        System.out.println("\nResult of countOccurance():");
        System.out.println(countOccurance(sourceList, argsForMatch));
        System.out.println("\nResult of toList():");
        System.out.println(toList(targetArray));
        System.out.println("\nResult of findUnique():");
        System.out.println(findUnique(toList(targetArray)));
        System.out.println("\nResult of calcOccurance():");
        calcOccurance(calcOccuranceList);
        System.out.println("\nResult of findOccurance():");
        System.out.println(findOccurance(calcOccuranceList));


        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Alex", "12345");
        phoneBook.add("Jack", "123");
        phoneBook.add("Jack", "1233");
        phoneBook.add("Pit", "123456");


        
        System.out.println("\nResult of find():");
        System.out.println(phoneBook.find("Jack"));
        System.out.println("\nResult of findAll():");
        System.out.println(phoneBook.findAll("Jack"));
    }

    private static int countOccurance(List sourceList, String argsForMatch) {
        return Collections.frequency(sourceList, argsForMatch);
    }

    private static List<Integer> toList(int[] targetArray) {
        List<Integer> resultList = new ArrayList<>(targetArray.length);
        for (int i : targetArray) {
            resultList.add(i);
        }
        return resultList;
    }

    private static List<Integer> findUnique(List<Integer> sourceList) {
        Set<Integer> uniqueValuesSet = new HashSet<>(sourceList);
        List<Integer> uniqueValuesList = new LinkedList<>(uniqueValuesSet);
        return uniqueValuesList;
    }

    private static void calcOccurance(List<String> sourceList) {
        Set<String> uniqueValuesSet = new HashSet<>(sourceList);
        for (String uniqueWord : uniqueValuesSet) {
            System.out.println(uniqueWord + ": " + Collections.frequency(sourceList, uniqueWord));
        }
    }

    private static List<OccuranceEntity> findOccurance(List<String> sourceList) {
        List<OccuranceEntity> occuranceList = new LinkedList<>();
        Set<String> uniqueValuesSet = new HashSet<>(sourceList);
        for (String uniqueWord : uniqueValuesSet) {
            OccuranceEntity occuranceEntity = new OccuranceEntity(uniqueWord, Collections.frequency(sourceList, uniqueWord));
            occuranceList.add(occuranceEntity);
        }
        return occuranceList;
    }
}