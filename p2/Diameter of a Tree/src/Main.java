class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Constructed binary tree is
        //          5
        //        /   \
        //       8     6
        //      / \   /
        //     3   7 9
        Node root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(9);

        System.out.println(diameter(root));
        System.out.println(diameterOpt(root));
    }

    public static int diameter(Node root){
        if(root == null) return 0;

        int lefth = height(root.left);
        int righth = height(root.right);

        int ldia = diameter(root.left);
        int rdia = diameter(root.right);

        return Math.max(lefth + righth, Math.max(ldia, rdia));
    }

    public static int height(Node root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static int diameterOpt(Node root){
        if(root == null) return 0;
        int[] max = new int[]{Integer.MIN_VALUE};

        diameterUtil(root, max);

        return max[0];
    }

    public static int diameterUtil(Node root, int[] max){
        if(root == null) return 0;

        int hLeft = diameterUtil(root.left, max);
        int hRight = diameterUtil(root.right, max);

        max[0] = Math.max(max[0], hLeft + hRight);

        return 1 + Math.max(hLeft, hRight);
    }
}








