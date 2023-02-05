package competition;

public class RunAction implements Action {

    int distance;
    int trackLength;

    public RunAction(int distance, int trackLength) {
        this.distance = distance;
        this.trackLength = trackLength;
    }

    @Override
    public void doAction(Participant participant) {
        if (!isParticipantCanDoAction(participant)) {
            System.out.println(participant.getName() + " isn`t ran " + distance + ". It was passed " + participant.getMaxDistanceToRun());
            participant.setParticipantContinue(false);
        } else {
            System.out.println(participant.getName() + " is ran " + distance);
        }
    }

    private boolean isParticipantCanDoAction(Participant participant) {
        return trackLength <= participant.getMaxDistanceToRun() && distance <= participant.getMaxDistanceToRun();
    }
}
