package competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Competitions {

    private final List<Participant> participants = new ArrayList<>(
        Arrays.asList(new Human("Jack", 13, 5, 7),
                      new Robot("Verter", 5, 2, 5),
                      new Cat("Murzik", 9, 8 , 10))
    );

    private final List<Obstacle> obstacles = new ArrayList<>(
        Arrays.asList(new Wall(participants), new Track(participants)) //here need to replace
    );

    public void startCompetitions() {
        for (Obstacle obstacle : obstacles) {
            obstacle.overcome();
        }
    }
}
