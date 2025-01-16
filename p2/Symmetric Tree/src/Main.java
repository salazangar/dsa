import java.util.Stack;

class Node{
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a sample symmetric binary tree
        //        1
        //       / \
        //      2   2
        //     / \ / \
        //    3  4 4  3
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(Node root) {
        if (root == null) return true;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root.left);
        s2.push(root.right);

        while(!s1.isEmpty() && !s2.isEmpty()){
            Node n1 = s1.pop();
            Node n2 = s2.pop();

            if(n1 == null && n2 == null) continue;

            if(n1 == null || n2 ==null ||n1.data != n2.data) return false;

            s1.push(n1.left);
            s2.push(n2.right);

            s1.push(n1.right);
            s2.push(n2.left);
        }
        return s1.isEmpty() && s2.isEmpty();
    }

}