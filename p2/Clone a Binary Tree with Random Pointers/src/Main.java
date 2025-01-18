import java.util.HashMap;
import java.util.Map;

class Node {
    int data;
    Node left, right, random;

    public Node(int x) {
        data = x;
        left = right = random = null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Constructing the binary tree with random pointers
        // Tree structure:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        // Random pointers:
        // 1 -> 5, 4 -> 1, 5 -> 3

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        node.random = node.left.right;
        node.left.left.random = node;
        node.left.right.random = node.right;

        Node clone = cloneTree(node);

        printTree(clone);
    }

    public static Node cloneTree(Node root){
        if(root == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node clone = copyNormalTree(root, map);

        copyRandom(clone, map);

        return clone;
    }

    public static Node copyNormalTree(Node root, HashMap<Node, Node> map){
        if(root == null) return null;

        Node newNode = new Node(root.data);

        map.put(newNode, root);

        newNode.left = copyNormalTree(root.left, map);
        newNode.right = copyNormalTree(root.right, map);

        return newNode;
    }

    public static void copyRandom(Node node, HashMap<Node, Node> map){
        if(node == null) return;
        node.random = map.get(node).random;

        if(node.left != null) copyRandom(node.left, map);
        if(node.right != null) copyRandom(node.right, map);
    }

    static void printTree(Node curr) {
        if (curr == null)
            return;
        printTree(curr.left);
        System.out.print("[" + curr.data + " ");
        if (curr.random == null)
            System.out.print("NULL], ");
        else
            System.out.print(curr.random.data + "], ");
        printTree(curr.right);
    }

}









