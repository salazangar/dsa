// Representation of input binary tree 2 (mirror)
//        1
//       / \
//      2   3
//     / \
//    4   5

import java.util.Stack;

class Node{
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.right.left = new Node(5);
        root1.right.right = new Node(4);


        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);

        System.out.println(ifMirrorRecursive(root1, root2));
        System.out.println(ifMirror(root1, root2));
    }

    public static boolean ifMirrorRecursive(Node r1, Node r2){
        if(r1 == null  && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        return r1.data == r2.data && ifMirrorRecursive(r1.left, r2.right) && ifMirrorRecursive(r1.right, r2.left);
    }

    public static boolean ifMirror(Node r1, Node r2){
        if(r1 == null  && r2 == null) return true;
        if(r1 == null || r2 == null) return false;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(r1);
        s2.push(r2);

        while(!s1.isEmpty() && !s2.isEmpty()){
            r1 = s1.pop();
            r2 = s2.pop();

            if(r1.data != r2.data) return false;

            if(r1.left != null && r2.right != null){
                s1.push(r1.left);
                s2.push(r2.right);
            } else if (r1.left != null || r2.right != null) return false;

            if(r1.left != null && r2.right != null){
                s1.push(r1.left);
                s2.push(r2.right);
            } else if (r1.left != null || r2.right != null) return false;
        }
        return s1.isEmpty() && s2.isEmpty();
    }

}













