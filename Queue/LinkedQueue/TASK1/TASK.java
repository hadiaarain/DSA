public class TASK implements IQueue {
    private class Node {
        public Object data;
        public Node next;
        public Node prev;

        public Node(Object data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node(Object data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size;
    private Node head = new Node(null);

    public TASK() {
        this.size = 0;
        head.next = head;
        head.prev = head;
    }

    public int size() {
        return size;
    }

    public Object first() {
        if (size == 0) {
            return null;
        }
        return head.next.data;
    }

    public void add(Object o) {
        Node newNode = new Node(o, head, head.prev);
        head.prev.next = newNode;
        head.prev = newNode;
        size++;
    }

    public Object remove() {
        if (size == 0) {
            return null;
        }
        Object temp = head.next.data;
        head.next = head.next.next;
        head.next.prev = head;
        size--;

        return temp;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node p = head.next;
        while (p != head) {
            sb.append(p.data);
            sb.append(" ");
            p = p.next;
        }
        return sb.toString();
    }

    public int sum() {
        int sum = 0;
        Node p = head.next;
        while (p != head) {
            sum += (int) p.data;
            p = p.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        TASK credit = new TASK();
        credit.add(100);
        credit.add(300);
        credit.add(500);
        credit.add(900);

        TASK debit = new TASK();
        debit.add(200);
        debit.add(500);
        debit.add(400);
        debit.add(100);

        System.out.println("Credit queue size: " + credit.size());
        System.out.println("Debit queue size: " + debit.size());
        System.out.println("Credit queue: " + credit.toString());
        System.out.println("Debit queue: " + debit.toString());
        System.out.println("Sum of credit queue: " + credit.sum());
        System.out.println("Sum of debit queue: " + debit.sum());

        int balance = credit.sum() - debit.sum();
        System.out.println("Balance: " + balance);
    }
}