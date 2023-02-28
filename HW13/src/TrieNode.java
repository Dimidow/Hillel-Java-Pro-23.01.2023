public class TrieNode {

    private Node rootNode;

    public TrieNode() {
        rootNode = null;
    }

    public void add(Node node) {
        if (rootNode == null) {
            rootNode = node;
        } else {
            Node currentNode = rootNode;
            Node parentNode;
            while (true) {
                parentNode = currentNode;
                if (node.getDataElement() == currentNode.getDataElement()) {
                    return;
                } else if (node.getDataElement() < currentNode.getDataElement()) {
                    currentNode = currentNode.getLeftPointer();
                    if (currentNode == null) {
                        return;
                    }
                } else {
                    currentNode = currentNode.getRightPointer();
                    if (currentNode == null) {
                        parentNode.setRightPointer(node);
                        return;
                    }
                }
            }
        }
    }

    public Node findNode(int value) {
        Node currentNode = rootNode;
        while (currentNode.getDataElement() != value) {
            if (value < currentNode.getDataElement()) {
                currentNode = currentNode.getLeftPointer();
            } else {
                currentNode = currentNode.getRightPointer();
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
               "rootNode=" + rootNode +
               '}';
    }
}