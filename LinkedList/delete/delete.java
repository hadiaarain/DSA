public class delete {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node deleteit(Node a, int x) {
        if (a == null) {
            return null;
        }

        if (a.data == x) {
            return a.next;
        }

        Node b = a;
        while (b.next != null) {
            if (b.next.data == x) {
                b.next = b.next.next;
            }
            b = b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        delete list = new delete();
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        // Delete the node with value 20
        list.deleteit(head, 20);

        // Print the linked list
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
    }
}