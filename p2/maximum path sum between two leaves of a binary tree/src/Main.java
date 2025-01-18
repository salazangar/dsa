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

        int[] max = new int[]{Integer.MIN_VALUE};

        maxPathSumLeaves(root,max);

        System.out.println(max[0]);
    }

    public static int maxPathSumLeaves(Node root, int[] max){
        if(root == null) return 0;

        int left = maxPathSumLeaves(root.left, max);
        int right = maxPathSumLeaves(root.right, max);

        if(root.left != null && root.right != null){
            max[0] = Math.max(root.data + left + right, max[0]);

            return Math.max(left, right) + root.data;
        }
        return root.data + (root.right != null? right : left);
    }
}








