// Tree structure:
//        1
//       / \
//      2   3
//     / \ / \
//    4  5 6  7
//          \  \
//           8  9

import java.util.*;

class Node{
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
    }
}
class Pair{
    Node data;
    int hd;

    public Pair(int hd, Node data) {
        this.data = data;
        this.hd = hd;
    }
}

public class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);

        List<Integer> result = verticalOrderHashMap(root);

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static List<Integer> verticalOrder(Node root){
        Map<Integer, List<Integer>> map = new TreeMap<>();
        List<Integer> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, root));

        while(!q.isEmpty()){
            Node curr = q.peek().data;
            int hd = q.peek().hd;
            q.poll();
            
            if(!map.containsKey(hd)){
                map.put(hd, new ArrayList<>());
            }
            map.get(hd).add(curr.data );
            
            if(curr.left != null) q.add(new Pair(hd-1, curr.left));
            if(curr.right != null) q.add(new Pair(hd+1, curr.right));
        }
        for (Integer x : map.keySet()) {
            res.addAll(map.get(x));
        }
        return res;
    }

    public static List<Integer> verticalOrderHashMap(Node root){
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, root));

        int min = 0, max = 0;
        while(!q.isEmpty()){
            Node curr = q.peek().data;
            int hd = q.peek().hd;
            q.poll();

            if(!map.containsKey(hd)){
                map.put(hd, new ArrayList<>());
            }
            map.get(hd).add(curr.data );

            if(curr.left != null) q.add(new Pair(hd-1, curr.left));
            if(curr.right != null) q.add(new Pair(hd+1, curr.right));

            min = Math.min(min, hd);
            max = Math.max(max, hd);
        }
        for (int i = min; i <= max; i++){
            res.addAll(map.get(i));
        }
        return res;
    }

}