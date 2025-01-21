import java.util.Stack;

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

        System.out.println("Given Linked list:");
        printList(head);

        System.out.println("After reversing : " );
//        printList(reverseLLIterative(head));
//        printList(reverseLLRecursive(head));
        printList(reverseLLStack(head));
    }

    public static void printList(Node head){
        System.out.print(" head -> ");
        while(head.next != null){
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println(head.data);
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

    public static Node reverseLLRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node node = reverseLLRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return node;
    }

    public static Node reverseLLStack(Node head){
        if(head == null) return null;
        if(head.next == null) return head;

        Stack<Node> stack = new Stack<>();
        Node temp = head;

        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        Node newHead = stack.pop();
        temp = newHead;

        while(!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return newHead;
    }
}




