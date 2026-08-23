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

    public int count(Node a) {

        if (a == null) {
            return 0;
        }

        int count = 0;

        for (Node i = a; i != null; i = i.next) {
            count++;
        }

        return count;
    }

    public int sum(Node a) {

        if (a == null) {
            return 0;
        }

        int sum = 0;

        for (Node i = a; i != null; i = i.next) {
            sum = sum + i.data;
        }

        return sum;
    }

    public double avg(Node a) {

        if (a == null) {
            return 0;
        }

        int sum = 0;
        int count = 0;

        for (Node i = a; i != null; i = i.next) {
            sum = sum + i.data;
            count++;
        }

        return (double) sum / count;
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Count = " + head.count(head));
        System.out.println("Sum = " + head.sum(head));
        System.out.println("Average = " + head.avg(head));
    }
}