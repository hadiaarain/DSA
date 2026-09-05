public class StackByLinkedList implements IStack {

    // =========================================
    // NODE CLASS
    // =========================================

    private class Node {

        Object data;
        Node next;

        private Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // =========================================
    // ATTRIBUTES
    // =========================================

    private int size;
    private Node top;

    // =========================================
    // SIZE
    // =========================================

    public int Size() {
        return size;
    }

    // =========================================
    // PUSH
    // =========================================

    public void Push(Object obj) {

        top = new Node(obj, top);

        size++;
    }

    // =========================================
    // POP
    // =========================================

    public Object Pop() {

        if (size == 0) {
            throw new IllegalStateException("Stack is Empty");
        }

        Object temp = top.data;

        top = top.next;

        size--;

        return temp;
    }

    // =========================================
    // PEEK
    // =========================================

    public Object Peek() {

        if (size == 0) {
            throw new IllegalStateException("Stack is Empty");
        }

        return top.data;
    }

    // =========================================
    // BOTTOM
    // =========================================

    public Object Bottom() {

        if (size == 0) {
            throw new IllegalStateException("Stack is Empty");
        }

        Node current = top;

        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    // =========================================
    // IS EMPTY
    // =========================================

    public boolean is_Empty() {

        return size == 0;
    }

    // =========================================
    // SUM
    // =========================================

    public int Sum() {

        int sum = 0;

        Node current = top;

        while (current != null) {

            if (current.data instanceof Integer) {

                sum += (Integer) current.data;
            }

            current = current.next;
        }

        return sum;
    }

    // =========================================
    // SEARCH
    // =========================================

    public boolean Search(Object obj) {

        Node current = top;

        while (current != null) {

            if (current.data.equals(obj)) {

                return true;
            }

            current = current.next;
        }

        return false;
    }

    // =========================================
    // REPLACE
    // =========================================

    public void Replace(Object oldObj, Object newObj) {

        Node current = top;

        while (current != null) {

            if (current.data.equals(oldObj)) {

                current.data = newObj;

                return;
            }

            current = current.next;
        }
    }

    // =========================================
    // DELETE
    // =========================================

    public void Delete(Object obj) {

        if (top == null) {
            return;
        }

        // If element is at TOP
        if (top.data.equals(obj)) {

            top = top.next;

            size--;

            return;
        }

        // Search remaining nodes
        Node current = top;

        while (current.next != null) {

            if (current.next.data.equals(obj)) {

                current.next = current.next.next;

                size--;

                return;
            }

            current = current.next;
        }
    }

    // =========================================
    // REVERSE
    // =========================================

    public void Rev() {

        int c=0;
        Object[] arr = new Object[size];
        
        System.out.println("Original Array: ");
        for(Node i=top;i!=null;i=i.next){
            System.out.println(arr[c++]=i.data);
        }
        
        System.out.println();
        
        System.out.println("Reversed Array: ");
        for(int i=arr.length-1;i>=0;i--){
            System.out.println(arr[i]);
    }}

    // =========================================
    // SUBSTACK
    // =========================================
    // start and end are positions
    // Example: Substack(1, 3)

    public StackByLinkedList Substack(int start, int end) {

        StackByLinkedList result = new StackByLinkedList();

        if (start < 0 || end >= size || start > end) {
            return result;
        }

        Node current = top;

        int index = 1;

        while (current != null && index <= end) {

            if (index >= start ) {

                result.Push(current.data);
            }

            current = current.next;

            index++;
        }

        return result;
    }

    // =========================================
    // MERGE
    // =========================================

    public void Merge(StackByLinkedList s) {

        if (s == null || s.size == 0) {
            return;
        }

        Node current = s.top;

        // Store elements temporarily
        Object[] temp = new Object[s.size];

        int i = 0;

        while (current != null) {

            temp[i] = current.data;

            i++;

            current = current.next;
        }

        // Push in reverse order
        for (i = temp.length - 1; i >= 0; i--) {

            Push(temp[i]);
        }
    }

    // =========================================
    // MIDDLE ELEMENT
    // =========================================

    public Object MiddleElement() {

        if (size == 0) {
            throw new IllegalStateException("Stack is Empty");
        }

        Node current = top;

        int middle = size / 2;

        for (int i = 0; i < middle; i++) {

            current = current.next;
        }

        return current.data;
    }

    // =========================================
    // TO STRING
    // =========================================

    public String toString() {

        if (size == 0) {
            return "Stack is Empty";
        }

        StringBuffer bf = new StringBuffer();

        Node current = top;

        while (current != null) {

            bf.append(current.data + " ");

            current = current.next;
        }

        return bf.toString();
    }

    // =========================================
    // EQUALS
    // =========================================

    public boolean Equals(StackByLinkedList s) {

        if (s == null) {
            return false;
        }

        if (this.size != s.size) {
            return false;
        }

        Node p = this.top;

        Node q = s.top;

        while (p != null && q != null) {

            if (!p.data.equals(q.data)) {

                return false;
            }

            p = p.next;

            q = q.next;
        }

        return true;
    }

    // =========================================
    // RESIZE
    // =========================================
    // Linked List does NOT need resize.

    public void Resize() {

        // Nothing to do
    }

    // =========================================
    // MAIN
    // =========================================

    public static void main(String[] args) {

        // -------------------------------------
        // CREATE STACK
        // -------------------------------------

        StackByLinkedList s1 = new StackByLinkedList();

        s1.Push(10);
        s1.Push(20);
        s1.Push(30);
        s1.Push(40);
        s1.Push(50);

        System.out.println("Stack: " + s1);

        // -------------------------------------
        // SIZE
        // -------------------------------------

        System.out.println("Size: " + s1.Size());

        // -------------------------------------
        // PEEK
        // -------------------------------------

        System.out.println("Top: " + s1.Peek());

        // -------------------------------------
        // BOTTOM
        // -------------------------------------

        System.out.println("Bottom: " + s1.Bottom());

        // -------------------------------------
        // SUM
        // -------------------------------------

        System.out.println("Sum: " + s1.Sum());

        // -------------------------------------
        // SEARCH
        // -------------------------------------

        System.out.println("Search 30: " + s1.Search(30));

        System.out.println("Search 100: " + s1.Search(100));

        // -------------------------------------
        // REPLACE
        // -------------------------------------

        s1.Replace(30, 300);

        System.out.println("After replacing 30 with 300: " + s1);

        // -------------------------------------
        // DELETE
        // -------------------------------------

        s1.Delete(40);

        System.out.println("After deleting 40: " + s1);

        // -------------------------------------
        // MIDDLE
        // -------------------------------------

        System.out.println("Middle element: "
                + s1.MiddleElement());

        // -------------------------------------
        // POP
        // -------------------------------------

        System.out.println("Popped: " + s1.Pop());

        System.out.println("After Pop: " + s1);

        // -------------------------------------
        // REVERSE
        // -------------------------------------

        s1.Rev();

        System.out.println("After Reverse: " + s1);

        // -------------------------------------
        // SUBSTACK
        // -------------------------------------

        StackByLinkedList sub = s1.Substack(1, 2);

        System.out.println("Substack: " + sub);

        // -------------------------------------
        // SECOND STACK
        // -------------------------------------

        StackByLinkedList s2 = new StackByLinkedList();

        s2.Push(100);
        s2.Push(200);

        System.out.println("Stack 2: " + s2);

        // -------------------------------------
        // MERGE
        // -------------------------------------

        s1.Merge(s2);

        System.out.println("After Merge: " + s1);

        // -------------------------------------
        // EQUALS
        // -------------------------------------

        StackByLinkedList s3 = new StackByLinkedList();

        s3.Push(200);
        s3.Push(100);

        System.out.println("Stack 3: " + s3);

        System.out.println("Stack 1 equals Stack 3: "
                + s1.Equals(s3));

        // -------------------------------------
        // IS EMPTY
        // -------------------------------------

        System.out.println("Is Stack Empty: "
                + s1.is_Empty());
    }
}
