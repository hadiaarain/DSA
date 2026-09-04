// LINKED STACK 

public class StackByLinkedList implements IStack {

    private class Node {
        // attributes
        Object data;
        Node next;

        // constructors
        private Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // attributes
    private int size;
    private Node top;

    // methods

    // Size
    public int Size() {
        return size;
    }

    // Push
    public void Push(Object obj) {
        top = new Node(obj, top);
        ++size;
    }

    // Pop
    public Object Pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is Empty");
        }
        Object temp = top.data;
        top = top.next;
        --size;
        return temp;
    }

    // Peek
    public Object Peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is Empty");
        }
        return top.data;
    }

    // is empty
    public boolean is_Empty() {
        return size == 0;
    }

    // to string
    public String toString() {
        if (size == 0) {
            throw new IllegalStateException("Stack is Empty");
        }
        StringBuffer bf = new StringBuffer(); // Stringbuffer allows us to append multiple objects, it is a container
                                              // for building a string
        for (Node i = top; i != null; i = i.next) {
            bf.append(i.data + " ");
        }
        return bf + " ";
    }

    // Equals
    public boolean equals(StackByLinkedList s) {

        if (this.size != s.size)
            return false;

        Node p = this.top;
        Node q = s.top;

        while (p != null && q != null) {

            if (!p.data.equals(q.data))
                return false;

            p = p.next;
            q = q.next;
        }

        return true;
    }

    public static void main(String[] args) {
        StackByLinkedList s1 = new StackByLinkedList();
        s1.Push(10);
        s1.Push(20);
        s1.Push(30);
        System.out.println("Stack 1: " + s1.toString());
        System.out.println("Size: " + s1.Size());
        System.out.println("Top: " + s1.Peek());
        System.out.println("Popped: " + s1.Pop());
        System.out.println("Stack 1 after pop: " + s1.toString());
        System.out.println("Size: " + s1.Size());
    }
}