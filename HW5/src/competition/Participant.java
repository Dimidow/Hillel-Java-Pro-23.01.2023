package competition;

public abstract class Participant {

    private final String name;
    private final int distance;
    private final int maxDistanceToRun;
    private final int maxHeightToJump;
    private boolean isParticipantContinue = true;

    public Participant(String name, int distance, int maxDistanceToRun, int maxHeightToJump) {
        this.name = name;
        this.distance = distance;
        this.maxDistanceToRun = maxDistanceToRun;
        this.maxHeightToJump = maxHeightToJump;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int getMaxDistanceToRun() {
        return maxDistanceToRun;
    }

    public int getMaxHeightToJump() {
        return maxHeightToJump;
    }

    public void someAction(Action action) {
        if (!isParticipantContinue) {
            return;
        }
        action.doAction(this);
    }

    abstract public void run(int distance, int trackLength);

    abstract public void jump(int distance, int wallHeight);


    public void setParticipantContinue(boolean participantContinue) {
        isParticipantContinue = participantContinue;
    }
}
