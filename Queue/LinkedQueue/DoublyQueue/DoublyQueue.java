public class DoublyQueue implements IQueue {
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

    public DoublyQueue() {
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

    public static void main(String[] args) {
        DoublyQueue d1 = new DoublyQueue();
        d1.add(10);
        d1.add(20);
        d1.add(30);
        d1.add(40);

        System.out.println("Size: " + d1.size());
        System.out.println("First: " + d1.first());
        System.out.println("Remove: " + d1.remove());
        System.out.println("Size after remove:   " + d1.size());
        System.out.println("First after removal: " + d1.first());
    }
}