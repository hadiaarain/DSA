public class LinkedArrayTraverse {

    public class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void TraverseLinkedArray(Node head) {

        // Base case
        if (head == null) {
            System.out.println("The linked array is empty.");
            return;
        }

        System.out.println(head.data);

        // Recursive call
        TraverseLinkedArray(head.next);
    }

    public static void main(String[] args) {

        LinkedArrayTraverse linkedArrayTraverse = new LinkedArrayTraverse();

        Node head = linkedArrayTraverse.new Node(1);

        head.next = linkedArrayTraverse.new Node(2);
        head.next.next = linkedArrayTraverse.new Node(3);
        head.next.next.next = linkedArrayTraverse.new Node(4);
        head.next.next.next.next = linkedArrayTraverse.new Node(5);

        linkedArrayTraverse.TraverseLinkedArray(head);
    }
}