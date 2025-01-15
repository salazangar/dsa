import java.net.Inet4Address;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

//        ArrayList<Integer> result = leftViewRecursion(root);
        ArrayList<Integer> result = leftViewLevelOrder(root);

        System.out.println(result);
    }

    public static ArrayList<Integer> leftViewRecursion(Node root){
        int[] level = new int[]{0};
        ArrayList<Integer> res = new ArrayList<>();
        recursion(root,0, level, res);
        return res;
    }
    public static void recursion(Node node,int level, int[] maxLevel, ArrayList<Integer> res){
        if(node == null) return;

        if(maxLevel[0] <= level){
            res.add(node.data);
            maxLevel[0] = level + 1;
        }

        recursion(node.left, level + 1, maxLevel, res);
        recursion(node.right, level + 1, maxLevel, res);
    }

    public static ArrayList<Integer> leftViewLevelOrder(Node root){
        if(root == null) return new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node curr = q.poll();
                if(i == 0) res.add(curr.data);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return res;
    }
}










