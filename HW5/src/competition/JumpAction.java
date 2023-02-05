package competition;

public class JumpAction implements Action {

    int distance;
    int wallHeight;

    public JumpAction(int distance, int wallHeight) {
        this.distance = distance;
        this.wallHeight = wallHeight;
    }

    @Override
    public void doAction(Participant participant) {
        if (!isParticipantCanDoAction(participant)) {
            System.out.println(participant.getName() + " isn`t jump " + distance + ". It was passed " + participant.getMaxHeightToJump());
            participant.setParticipantContinue(false);
        } else {
            System.out.println(participant.getName() + " is jump " + distance);
        }
    }

    private boolean isParticipantCanDoAction(Participant participant) {
        return wallHeight <= participant.getMaxHeightToJump() && distance <= participant.getMaxHeightToJump();
    }
}