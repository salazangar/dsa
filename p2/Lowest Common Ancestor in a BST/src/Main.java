class Node{
    Node left,right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        int n1 = 10, n2 = 22;

//        System.out.println(findLca(root, n1, n2).data);
//        System.out.println(findLcaRecursively(root, n1, n2).data);
        System.out.println(findLcaIterative(root, n1, n2).data);
    }

    public static Node findLca(Node root, int n1, int n2){
        if(root == null) return null;

        if(root.data == n1 || root.data == n2){
            return root;
        }

        Node leftLca = findLca(root.left, n1, n2);
        Node rightLca = findLca(root.right, n1, n2);

        if(leftLca != null && rightLca != null){
            return root;
        }

        return leftLca != null ? leftLca : rightLca;
    }   // for regular binary trees also

    public static Node findLcaRecursively(Node root, int n1, int n2){
        if(root == null) return null;

        if(n1 > root.data && n2 > root.data){
            return findLcaRecursively(root.right, n1, n2);
        }
        if(n1 < root.data && n2 < root.data){
            return findLcaRecursively(root.left, n1, n2);
        }
        return root;
    }

    private static Node findLcaIterative(Node root, int n1, int n2) {
        if(root == null)    return null;
        Node ori = root;

        while(root != null ){
            if(n1 > root.data && n2 > root.data){
                root = root.right;
            }
            else if(n1 < root.data && n2 < root.data){
                root = root.left;
            }else
                break;
        }
        return ori;
    }


}









