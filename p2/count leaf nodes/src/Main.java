import java.util.LinkedList;
import java.util.Queue;

class Node{
    Node left, right;
    int data;

    public Node(int data) {
        left = right = null;
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        // Representation of input binary tree
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(countLeaves(root));
    }

    public static int countLeaves(Node root){
        if(root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        int count = 0;
        q.add(root);

        while(!q.isEmpty()){
            root = q.poll();

            if(root.left == null && root.right == null) count++;

            if(root.left != null) q.add(root.left);
            if(root.right != null) q.add(root.right);
        }
        return count;
    }
}




