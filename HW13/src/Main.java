import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        TrieNode trieNode = new TrieNode();

        trieNode.add(new Node(13));
        trieNode.add(new Node(14));
        trieNode.add(new Node(5));
        trieNode.add(new Node(18));
        trieNode.add(new Node(40));
        System.out.println("\nresult of findNode():");
        System.out.println(trieNode.findNode(14));

        Iterator<Node> nodeIterator = trieNode.iterator();
        try {
            System.out.println("\niterate by nodes:");
            while (nodeIterator.hasNext()) {
                System.out.println(nodeIterator.next());
            }
        } catch (IllegalStateException illegalStateException) {
            System.out.println("Error message: " + illegalStateException.getMessage());
        }
    }
}