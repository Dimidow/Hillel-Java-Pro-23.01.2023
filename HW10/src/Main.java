import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String filesPath = "src/exceptions/";
        FileNavigator fileNavigator = new FileNavigator(filesPath);


        fileNavigator.add(new FileData("Name.java", 13, "src/excejptions/"));
        fileNavigator.add(new FileData("Name.java", 13, "src/exceptions/"));
        System.out.println("\nresult of find():");
        System.out.println(fileNavigator.find(filesPath));
        System.out.println("\nresult of filterBySize():");
        System.out.println(fileNavigator.filterBySize(177));
        fileNavigator.remove(filesPath + "132");
        System.out.println("\nresult of sortBySize():");
        System.out.println(fileNavigator.sortBySize());
    }
}