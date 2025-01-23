// rotating LEFT

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        // 10 -> 20 -> 30 -> 40
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

//        head = rotateNaive(head, 6);
        head = rotate(head, 6);
        printList(head);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    static Node rotateNaive(Node head, int n){
        if(n == 0 || head == null) return head;

        Node curr = head;

        while(curr.next != null){
            curr = curr.next;

        }


        for (int i = 0; i < n; i++) {
            curr.next = head;
            curr = curr.next;
            head = head.next;
            curr.next = null;
        }
        return head;
    }

    static Node rotate(Node head, int n){
        if(n == 0 || head == null) return head;

        Node curr = head;
        int len = 1;

        while(curr.next != null){
            curr = curr.next;
            len++;
        }

        n = n % len;

        if(n == 0) return head;

        curr.next = head;
        curr = head;

        for (int i = 1; i < n; i++) {
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }
}