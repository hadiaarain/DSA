public class ArrayQueue implements IQueue {

    // Array to store queue elements
    private Object[] a;

    // Number of elements
    private int size;

    // Index of first element
    private int front;

    // Index where next element will be added
    private int rear;

    // Constructor
    public ArrayQueue() {
        a = new Object[10];
        size = 0;
        front = 0;
        rear = 0;
    }

    // Size
    public int size() {
        return size;
    }

    // Add
    public void add(Object o) {

        // If array is full, increase its size
        if (size == a.length) {
            Resize();
        }

        a[rear] = o;

        rear++;

        size++;
    }

    // Remove
    public Object remove() {

        if (size == 0) {
            return null;
        }

        Object temp = a[front];

        a[front] = null;

        front++;

        size--;

        return temp;
    }

    // First
    public Object first() {

        if (size == 0) {
            return null;
        }

        return a[front];
    }

    // Resize
    private void Resize() {

        Object[] newArray = new Object[a.length * 2];

        for (int i = 0; i < size; i++) {
            newArray[i] = a[front + i];
        }

        a = newArray;

        front = 0;

        rear = size;
    }

    // Main
    public static void main(String[] args) {

        ArrayQueue q1 = new ArrayQueue();

        q1.add(10);
        q1.add(20);
        q1.add(30);
        q1.add(40);

        System.out.println("Queue: " + q1);

        System.out.println("Size: " + q1.size());

        System.out.println("First: " + q1.first());

        System.out.println("Removed: " + q1.remove());

        System.out.println("Size after removal: " + q1.size());

        System.out.println("First after removal: " + q1.first());
    }

    // To String
    public String toString() {

        String result = "";

        for (int i = 0; i < size; i++) {
            result += a[front + i] + " ";
        }

        return result;
    }
}
