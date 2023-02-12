package competition;

import java.util.List;

public class Wall extends Obstacle {
    private final int wallHeight = 9;

    @Override
    public void overcome(List<Participant> participants) {
        for (Participant participant : participants) {
            participant.jump(participant.getDistance(), wallHeight);
        }
    }
}