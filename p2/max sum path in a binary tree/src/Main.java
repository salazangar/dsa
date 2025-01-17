class Node{
    Node left,  right;
    int data;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Construct a sample binary tree
        //
        //         1
        //       /   \
        //     -2     3
        //     / \   / \
        //    8  -1  4  -5

        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(8);
        root.left.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.right = new Node(-5);

        int[] max = new int[]{root.data};
        maxPathSum(root,max);
        System.out.println("The max path sum is :" + max[0] );
    }

    public static int maxPathSum(Node root, int[] max){
        if(root == null) return 0;

        int left = Math.max(0, maxPathSum(root.left, max));
        int right = Math.max(0, maxPathSum(root.right, max));

        max[0] = Math.max(max[0], root.data + left + right);

        return root.data + Math.max(left, right);
    }
}