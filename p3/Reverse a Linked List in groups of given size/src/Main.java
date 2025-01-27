//Input: head: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL, k = 2
//Output: head: 2 -> 1 -> 4 -> 3 -> 6 -> 5 -> NULL

class Node{
    Node next;
    int data;

    public Node(int data) {
        this.next = null;
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = reverseKGroupIterative(head, 3);
        printList(head);
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static Node reverseKGroupIterative(Node head, int k){
        Node curr = head;
        Node newHead = null;
        Node tail = null;

        while(curr != null){

            Node groupHead = curr;
            Node next = null;
            Node prev = null;
            int count = 0;

            while(curr != null && count < k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            if(newHead == null){
                newHead = prev;
            }

            if(tail != null){
                tail.next = prev;
            }

            tail = groupHead;
        }
        return newHead;
    }


}









