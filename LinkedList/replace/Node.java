public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node replace(Node a, int x, int y) {
        if (a == null || a.data > x) {
            return null;
        }

        if (a.data == x) {
            a.data = y;
        }

        for (Node i = a; i != null; i = i.next) {
            if (i.data == x) {
                i.data = y;
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        head.replace(head, 30, 36);
        for (Node i = head; i != null; i = i.next) {
            System.out.println(i.data + " ");
        }

    }

}