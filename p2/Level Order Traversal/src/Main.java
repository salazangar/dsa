import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
//        ArrayList<ArrayList<Integer>> res = levelOrderStack(root);
//        ArrayList<ArrayList<Integer>> res= levelOrderQueue(root);
        ArrayList<ArrayList<Integer>> res= levelOrderSpiral(root);

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

    public static ArrayList<ArrayList<Integer>> levelOrderQueue(Node root){
        if(root == null ) return new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        q.add(root);
        int currLevel = 0;

        while(!q.isEmpty()){
            int len = q.size();
            res.add(new ArrayList<>());

            for (int i = 0; i < len; i++) {
                Node node = q.poll();

                res.get(currLevel).add(node.data);

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            currLevel++;
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> levelOrderSpiral(Node root){
        Queue<Node> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        q.add(root);
        int level = 0;

        while(!q.isEmpty()){
            int len = q.size();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++){
                Node curr = q.poll();
                arr[i] = curr.data;

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            res.add(new ArrayList<>());
            if(level % 2 == 0){
                for (int i = len -1 ; i >= 0; i--) {
                    res.get(level).add(arr[i]);
                }
            }else{
                for (int i = 0 ; i < len; i++) {
                    res.get(level).add(arr[i]);
                }
            }
            level++;
        }
        return res;
    }
}







