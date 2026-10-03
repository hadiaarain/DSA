public class rev {

    // Node for Linked List
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // 1. Reverse N numbers
    static void reverseN(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n);
        reverseN(n - 1);
    }

    // 2. Reverse Array
    static void reverseArray(int[] a, int index) {
        if (index < 0) {
            return;
        }

        System.out.println(a[index]);
        reverseArray(a, index - 1);
    }

    // 3. Reverse Linked List
    static Node reverseLinkedList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseLinkedList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // Print Linked List
    static void printLinkedList(Node head) {
        if (head == null) {
            return;
        }

        System.out.println(head.data);
        printLinkedList(head.next);
    }

    public static void main(String[] args) {

        // Reverse N
        System.out.println("Reverse N:");
        reverseN(5);


        // Reverse Array
        System.out.println("\nReverse Array:");

        int[] a = {1, 2, 3, 4, 5};

        reverseArray(a, a.length - 1);


        // Create Linked List
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);


        // Reverse Linked List
        head = reverseLinkedList(head);

        System.out.println("\nReverse Linked List:");
        printLinkedList(head);
    }
}