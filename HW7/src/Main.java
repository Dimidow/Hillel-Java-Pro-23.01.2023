import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nresult of findSymbolOccurance():");
        System.out.println(findSymbolOccurance("Some string for match", 'f'));
        System.out.println("\nresult of findWordPosition():");
        System.out.println(findWordPosition("Apple", "car"));
        System.out.println("\nresult of stringReverse():");
        System.out.println(stringReverse("stringReverse"));
        System.out.println("\nresult of isPalindrome():");
        System.out.println(isPalindrome("Allo"));
        System.out.println("\nresult of guessWord():");
        System.out.println(guessWord());
    }

    private static int findSymbolOccurance(String stringRow, char c) {
        int match = 0;
        char[] charArray = stringRow.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == c) {
                match++;
            }
        }
        return match;
    }

    private static int findWordPosition(String source, String target) {
        char[] sourceCharArray = source.toCharArray();
        char[] targetCharArray = target.toCharArray();
        if (sourceCharArray.length == 0 || targetCharArray.length == 0) {
            return -1;
        }
        for (int i = 0; i < sourceCharArray.length; i++) {
            if (targetCharArray.length > sourceCharArray.length - i) {
                break;
            }
            int j = 0;
            for (; j < targetCharArray.length; j++) {
                if (sourceCharArray[i + j] != targetCharArray[j]) {
                    break;
                }
            }
            if (j == targetCharArray.length) {
                return i;
            }
        }
        return -1;
    }

    private static String stringReverse(String stringRow) {
        char[] stringRowToChar = stringRow.toCharArray();
        StringBuilder reversedRow = new StringBuilder();
        int reversedIndex = stringRowToChar.length - 1;
        for (int i = 0; i < stringRowToChar.length; i++) {
            reversedRow.append(stringRowToChar[reversedIndex]);
            reversedIndex--;
        }
        return reversedRow.toString();
    }

    private static boolean isPalindrome(String stringRow) {
        char[] stringRowToChar = stringRow.toCharArray();
        int j = stringRowToChar.length - 1;
        if (stringRowToChar.length == 1) {
            return true;
        }
        for (int i = 0; i < (stringRowToChar.length) / 2; i++) {
            if (stringRowToChar[i] != stringRowToChar[j]) {
                return false;
            }
            j--;
        }
        return true;
    }

    private static String guessWord() {
        String[] words = {
            "apple", "orange", "lemon", "banana",
            "apricot", "avocado", "broccoli", "carrot", "cherry",
            "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"
        };
        Random random = new Random();
        String computerWord = words[random.nextInt(words.length)];
        Scanner scanner;
        boolean isWordsMatched = false;
        do {
            scanner = new Scanner(new InputStreamReader(System.in));
            String userWord = scanner.next();
            int guessCharIndex = 1;
            for (int i = 0; i < computerWord.length(); i++) {
                if (computerWord.charAt(i) != userWord.charAt(i)) {
                    guessCharIndex = i;
                    isWordsMatched = false;
                    break;
                } else {
                    isWordsMatched = true;
                }
            }
            if (!isWordsMatched) {
                StringBuffer hint = new StringBuffer("###############");
                System.out.println(hint.replace(0, guessCharIndex, computerWord.substring(0, guessCharIndex)));
            }
        } while (!isWordsMatched);
        return "Correct!";
    }
}