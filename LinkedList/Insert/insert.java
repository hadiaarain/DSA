public class insert {
    public class Node {
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

    public Node insertit(Node a, int x) {
        if (a == null || a.data > x) {
            a = new Node(x, a);
            return a;
        }

        Node b = a;
        while (b.next != null) {
            if (b.next.data > x) {
                break;
            }
            b = b.next;
        }
        Node newN = new Node(x, b.next);
        b.next = newN;

        return a;
    }

    public static void main(String[] args) {
        insert list = new insert();
        Node head = null;

        // Insert elements into the linked list
        head = list.insertit(head, 5);
        head = list.insertit(head, 3);
        head = list.insertit(head, 7);
        head = list.insertit(head, 1);

        // Print the linked list
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
    }
}