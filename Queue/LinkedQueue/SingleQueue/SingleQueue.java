public class SingleQueue implements IQueue {
    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private int size;
    private Node front;
    private Node rear;

    public SingleQueue() {
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    public int size() {
        return size;
    }

    public void add(Object o) {

        Node newNode = new Node(o);
        if (size == 0) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public Object remove() {
        if (size == 0) {
            return null;
        }
        size--;
        Object temp = front.data;
        front = front.next;
        return temp;
    }

    public Object first() {
        if (size == 0) {
            return null;
        }
        return front.data;
    }

    public static void main(String[] ars) {
        SingleQueue s1 = new SingleQueue();
        s1.add(10);
        s1.add(20);
        s1.add(30);
        s1.add(40);

        System.out.println("Size: " + s1.size());
        System.out.println("First: " + s1.first());
        System.out.println("Removed: " + s1.remove());
        System.out.println("Size after removal: " + s1.size());
    }
}
