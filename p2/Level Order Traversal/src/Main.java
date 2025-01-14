import java.util.ArrayList;

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
        root.left = new Node(3);
        root.right = new Node(2);
        root.right.right = new Node(4);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(5);

        // Perform level order traversal
        ArrayList<ArrayList<Integer>> res = levelOrderStack(root);

        for(ArrayList<Integer> list : res){
            System.out.println(list);
        }
    }

    public static ArrayList<ArrayList<Integer>> levelOrderStack(Node root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        recursion(root, 0, res);
        return res;
    }

    public static void recursion(Node root, int level, ArrayList<ArrayList<Integer>> res){
        if(root == null){
            return;
        }

        if(res.size() <= level){
            res.add(new ArrayList<>());
        }
        // add current to result at level
        res.get(level).add(root.data);

        recursion(root.left, level + 1, res);
        recursion(root.right, level + 1, res);
    }

}