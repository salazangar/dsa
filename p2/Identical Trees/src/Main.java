import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        System.out.println(ifIdentical(root1, root2));
        System.out.println(ifIdenticalIterative(root1, root2));
        System.out.println(ifIdenticalPostOrder(root1, root2));
    }

    public static boolean ifIdentical(Node n1, Node n2){
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;
        return n1.data == n2.data && ifIdentical(n1.left, n2.left) && ifIdentical(n1.right,n2.right);
    }

    public static boolean ifIdenticalIterative(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.data != root2.data) return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while(!q1.isEmpty() && !q2.isEmpty()){
            Node n1 = q1.poll();
            Node n2 = q2.poll();

            if(n1.data != n2.data) return false;

            if(n1.left != null && n2.left != null){
                q1.add(n1.left);
                q2.add(n2.left);
            } else if (n1.left != null || n2.left != null) {
                return false;
            }

            if(n1.right != null && n2.right != null){
                q1.add(n1.right);
                q2.add(n2.right);
            }else if(n1.right != null || n2.right != null){
                return false;
            }
        }
        return true;
    }

    public static boolean ifIdenticalPostOrder(Node r1, Node r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        if(r1.data != r2.data) return false;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while( r1 != null || !s1.isEmpty()  || r2 != null || !s2.isEmpty()){
            while(r1 != null){
                s1.push(r1);
                r1 = r1.left;
            }
            while(r2 != null){
                s2.push(r2);
                r2 = r2.left;
            }

            if(s1.size() != s2.size()) return false;

            r1 = s1.pop();
            r2 = s2.pop();
            if(r1.data != r2.data) return false;

            r1 = r1.right;
            r2 = r2.right;
        }
        return true;
    }
}





