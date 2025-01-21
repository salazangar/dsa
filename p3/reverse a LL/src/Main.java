class Node{
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Given Linked list:");
        printList(head);

        System.out.println("After reversing : " );
        printList(reverseLLIterative(head));
    }

    public static void printList(Node head){
        System.out.print(" head -> ");
        while(head.next != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print(head.data);
    }

    public static Node reverseLLIterative(Node head){
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}