import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Constructed binary tree is
//       10
//      /  \
//    8     2
//   /        \
//  3          90
class Node{
    Node left,right;
    int data;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}


public class Main {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(90);

        ArrayList<String> res = nextRightList(root);

        System.out.println(String.join(" ",res));
    }

    public static ArrayList<String> nextRightList(Node root){
        if(root == null) return new ArrayList<>();

        ArrayList<String> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node curr = q.poll();
                res.add(Integer.toString(curr.data));
                if(curr.left!= null) q.add(curr.left);
                if(curr.right!= null) q.add(curr.right);
            }
            res.add("#");
        }
        return res;
    }
}







