public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node insert(Node a, int x) {
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

    public Node[] sublist(Node a, int p, int q) {
        if (a == null || p < 0 || p > q) {
            return new Node[] { null, null };
        }

        int count = 1;
        Node b = a;
        Node z = null;
        while (b != null && count <= q) {
            if (count >= p) {
                z = insert(z, b.data);
            }
            b = b.next;
            count++;
        }

        return new Node[] { z, null };
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        int x = 2;
        int y = 5;

        Node[] res = head.sublist(head, x, y);
        Node p = res[0];
        for (Node i = p; i != null; i = i.next) {
            System.out.println(i.data + " ");
        }

    }
}