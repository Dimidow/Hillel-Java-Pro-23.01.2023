import java.util.Iterator;
import java.util.Stack;

public class NodeIterator implements Iterator<Node> {

    private final Stack<Node> stackNodes;

    public NodeIterator(Node rootNode) {
        stackNodes = new Stack<>();
        stackNodes.push(rootNode);
    }

    @Override
    public boolean hasNext() {
        return !stackNodes.isEmpty();
    }

    @Override
    public Node next() {
        if (!hasNext()) {
            throw new IllegalStateException("There is no Node more!");
        }
        Node currentNode = stackNodes.pop();
        if (currentNode.getRightPointer() != null) {
            stackNodes.push(currentNode.getRightPointer());
        }
        if (currentNode.getLeftPointer() != null) {
            stackNodes.push(currentNode.getLeftPointer());
        }
        return currentNode;
    }
}
