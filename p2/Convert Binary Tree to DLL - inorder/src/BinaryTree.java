class Node{
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}


public class BinaryTree {
    Node root;

    Node head = null;
    Node prev = null;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // convert to DLL
        tree.BinaryTree2DoubleLinkedList(tree.root);

        // Print the converted List
        tree.printList(tree.head);
    }

    public void BinaryTree2DoubleLinkedList(Node root){
        if(root == null) return;

        BinaryTree2DoubleLinkedList(root.left);

        //current
        if(prev == null){
            head = root;
        }else{
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        BinaryTree2DoubleLinkedList(root.right);
    }

    public void printList(Node node){
        if(node == null) return;
        while(node.right != null){
            System.out.print(node.data + "->");
            node = node.right;
        }
        System.out.print(node.data);
    }
}