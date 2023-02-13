import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> sourceList = new ArrayList<String>();
        String[] argsForMatch = new String[]{"Ford", "Mazda"};
        sourceList.add("Volvo");
        sourceList.add("BMW");
        sourceList.add("Ford");
        sourceList.add("Mazda");
        sourceList.add("Ford");
        sourceList.add("Mazda");
        sourceList.add("Ford");
        sourceList.add("Mazda");

        System.out.println(countOccurance(sourceList, argsForMatch));
    }

    private static int countOccurance (List sourceList, String[] argsForMatch){

        int countTimes = 0;
        System.out.println(sourceList.containsAll(Arrays.asList(argsForMatch)));
        int iterations = sourceList.size() / argsForMatch.length;
        for (int i = 0; i < iterations; i++){

        }


        return countTimes;
    }
}