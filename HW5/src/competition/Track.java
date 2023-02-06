package competition;

import java.util.List;

public class Track extends Obstacle {

    private final int trackLength = 10;

    @Override
    public void overcome(List<Participant> participants) {
        for (Participant participant : participants) {
            participant.run(participant.getDistance(), trackLength);
        }
    }
}
