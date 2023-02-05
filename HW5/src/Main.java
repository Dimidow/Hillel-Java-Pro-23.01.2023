import competition.Competitions;
import square.Calculation;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Calculation().getSummarySquare());
        new Competitions().startCompetitions();
    }
}