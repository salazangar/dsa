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
        // Representation of the input tree:
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(depthOfTree(root));
        System.out.println(depthOfTreeLevelOrder(root));
    }

    public static int depthOfTree(Node root){
        if(root == null) return 0;

        int left = depthOfTree(root.left);
        int right = depthOfTree(root.right);

        return Math.max(left, right) + 1;
    }

    public static int depthOfTreeLevelOrder(Node root){
        if(root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int h = 0;

        while(!q.isEmpty()){
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node curr = q.poll();
                if(curr.left !=null) q.add(curr.left);
                if(curr.right !=null) q.add(curr.right);
            }
            h++;
        }
        return h;
    }
}




