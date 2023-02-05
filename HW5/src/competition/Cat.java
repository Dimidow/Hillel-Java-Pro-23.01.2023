package competition;

public class Cat extends Participant {

    public Cat(String name, int distance, int maxDistanceToRun, int maxHeightToJump) {
        super(name, distance, maxDistanceToRun, maxHeightToJump);
    }

    @Override
    public void run(int distance, int trackLength) {
        Action action = new RunAction(distance, trackLength);
        someAction(action);
    }

    @Override
    public void jump(int distance, int wallHeight) {
        Action action = new JumpAction(distance, wallHeight);
        someAction(action);
    }
}