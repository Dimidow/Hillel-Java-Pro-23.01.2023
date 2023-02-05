package competition;

import java.util.List;

public class Wall extends Obstacle {

    private final List<Participant> participants;
    private final int wallHeight = 9;

    public Wall(List<Participant> participants) {
        this.participants = participants;
    }


    @Override
    public void overcome() {
        for (Participant participant : participants) {
            participant.jump(participant.getDistance(), wallHeight);
        }
    }
}