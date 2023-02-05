package competition;

import java.util.List;

public class Track extends Obstacle {

    private final List<Participant> participants;
    private final int trackLength = 10;

    public Track(List<Participant> participants) {
        this.participants = participants;
    }

    @Override
    public void overcome() {
        for (Participant participant : participants) {
            participant.run(participant.getDistance(), trackLength);
        }
    }
}
