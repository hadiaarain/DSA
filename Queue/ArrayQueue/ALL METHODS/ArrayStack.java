public class ArrayStack implements IQueue {

    // Array to store queue elements
    private Object[] a;

    // Number of elements
    private int size;

    // Index of first element
    private int front;

    // Index where next element will be added
    private int rear;

    // Constructor
    public ArrayStack() {
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

        // If rear reaches end of array,
        // make space or resize
        if (rear == a.length) {
            if (size < a.length) {
                // Shift elements to beginning
                for (int i = 0; i < size; i++) {
                    a[i] = a[front + i];
                }

                for (int i = size; i < a.length; i++) {
                    a[i] = null;
                }

                front = 0;
                rear = size;
            } else {
                Resize();
            }
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

        // Reset when queue becomes empty
        if (size == 0) {
            front = 0;
            rear = 0;
        }

        return temp;
    }

    // First
    public Object first() {

        if (size == 0) {
            return null;
        }

        return a[front];
    }

    // Rear
    public Object rear() {

        if (size == 0) {
            return null;
        }

        return a[rear - 1];
    }

    // is_Empty
    public boolean is_Empty() {

        return size == 0;
    }

    // Sum
    public double sum() {

        double sum = 0;

        for (int i = 0; i < size; i++) {

            if (a[front + i] instanceof Number) {
                sum += ((Number) a[front + i]).doubleValue();
            }
        }

        return sum;
    }

    // Search
    // Returns position of element
    // Returns -1 if not found
    public int search(Object o) {

        for (int i = 0; i < size; i++) {

            if (a[front + i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    // Replace
    // Replaces old value with new value
    public boolean replace(Object oldValue, Object newValue) {

        for (int i = 0; i < size; i++) {

            if (a[front + i].equals(oldValue)) {
                a[front + i] = newValue;
                return true;
            }
        }

        return false;
    }

    // Delete
    // Deletes first occurrence of given value
    public boolean delete(Object o) {

        int index = search(o);

        if (index == -1) {
            return false;
        }

        // Shift elements left
        for (int i = index; i < size - 1; i++) {
            a[front + i] = a[front + i + 1];
        }

        a[front + size - 1] = null;

        rear--;
        size--;

        return true;
    }

    // Reverse
    public void rev() {

        int left = 0;
        int right = size - 1;

        while (left < right) {

            Object temp = a[front + left];

            a[front + left] = a[front + right];

            a[front + right] = temp;

            left++;
            right--;
        }
    }

    // Subqueue
    // Creates a new queue from start position
    // to end position
    public ArrayStack subqueue(int start, int end) {

        ArrayStack s = new ArrayStack();

        if (start < 0 || end > size || start > end) {
            return s;
        }

        for (int i = start; i < end; i++) {
            s.add(a[front + i]);
        }

        return s;
    }

    // Merge
    // Combines this queue with another queue
    public ArrayStack merge(ArrayStack s) {

        ArrayStack result = new ArrayStack();

        // Add this queue
        for (int i = 0; i < size; i++) {
            result.add(a[front + i]);
        }

        // Add second queue
        for (int i = 0; i < s.size; i++) {
            result.add(s.a[s.front + i]);
        }

        return result;
    }

    // Middle
    public Object middle() {

        if (size == 0) {
            return null;
        }

        return a[front + size / 2];
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

    // To String
    public String toString() {

        String result = "";

        for (int i = 0; i < size; i++) {
            result += a[front + i] + " ";
        }

        return result;
    }

    // Equals
    public boolean equals(ArrayStack s) {

        if (s == null) {
            return false;
        }

        if (size != s.size) {
            return false;
        }

        for (int i = 0; i < size; i++) {

            if (!a[front + i].equals(s.a[s.front + i])) {
                return false;
            }
        }

        return true;
    }

    // Main
    public static void main(String[] args) {

        ArrayStack s1 = new ArrayStack();

        s1.add(10);
        s1.add(20);
        s1.add(30);
        s1.add(40);
        s1.add(50);

        System.out.println("Stack: " + s1);
        System.out.println("Size: " + s1.size());
        System.out.println("Top: " + s1.first());
        System.out.println("Rear: " + s1.rear());
        System.out.println("Is Empty: " + s1.is_Empty());
        System.out.println("Sum: " + s1.sum());

        System.out.println("Search 30: " + s1.search(30));

        s1.replace(30, 35);
        System.out.println("After Replace: " + s1);

        s1.delete(20);
        System.out.println("After Delete: " + s1);

        s1.rev();
        System.out.println("After Reverse: " + s1);

        System.out.println("Middle: " + s1.middle());

        ArrayStack s2 = s1.subqueue(1, 3);
        System.out.println("Subqueue: " + s2);

        ArrayStack s3 = new ArrayStack();
        s3.add(100);
        s3.add(200);

        ArrayStack merged = s1.merge(s3);
        System.out.println("Merged: " + merged);

        System.out.println("Equals: " + s1.equals(s3));
    }
}