//Given a Binary Tree consisting of N nodes, the task is to find the
// minimum number of cameras required to monitor the entire tree such that
// every camera placed at any node can monitor the node itself, its parent, and its immediate children.
class Node{
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {
    static int res = 0;
    public static void main(String[] args) {

        // Given Binary Tree
        Node root = new Node(0);
        root.left = new Node(0);
        root.left.left = new Node(0);
        root.left.left.left = new Node(0);
        root.left.left.left.right = new Node(0);

        System.out.println(minCameras(root));
    }

    // 0 -> leaf node, that means parent needs a camera
    // 1 -> parent of leaf node, will get a camera
    // 2 -> node is covered, without camera
    public static int minCameras(Node root){
        return (dfs(root) == 0 ? 1 : 0) + res;
    }
    public static int dfs(Node root){
        if(root == null) return 2;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left == 0 || right == 0){
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }
}









