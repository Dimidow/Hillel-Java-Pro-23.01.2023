public class Node {

    private int dataElement;

    private Node leftPointer;

    private Node rightPointer;

    public Node(int dataElement) {
        this.dataElement = dataElement;
        leftPointer = null;
        rightPointer = null;
    }

    public int getDataElement() {
        return dataElement;
    }

    public void setDataElement(int dataElement) {
        this.dataElement = dataElement;
    }

    public Node getLeftPointer() {
        return leftPointer;
    }

    public void setLeftPointer(Node leftPointer) {
        this.leftPointer = leftPointer;
    }

    public Node getRightPointer() {
        return rightPointer;
    }

    public void setRightPointer(Node rightPointer) {
        this.rightPointer = rightPointer;
    }

    @Override
    public String toString() {
        return "leftPointer=" + leftPointer +
               "|dataElement=" + dataElement +
               "|rightPointer=" + rightPointer +
               '\n';
    }

}
