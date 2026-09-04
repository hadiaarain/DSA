// ARRAY STACK 

public class ArrayStack implements IStack {

    // attributes
    private int size;
    private Object a[];

    // constructor
    public ArrayStack(int capacity) {
        a = new Object[capacity]; // declares an array of size " capacity " entered by user
    }

    // methods

    // size
    public int Size() {
        return size;
    }

    // Push
    public void Push(Object obj) {
        if (size == a.length) {
            Resize();
        }
        a[size++] = obj; // inserts obj at index size and increaments size by 1 so next on=bj goes to
                         // next index
    }

    // Pop
    public Object Pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is Empty");
        }

        Object temp = a[size - 1];
        a[size - 1] = null; // to avoid loitering
        size--;
        return temp;
    }

    // peek
    public Object Peek() {
        if (size == 0) {
            throw new IllegalStateException("Stack is Empty");
        }
        return a[size - 1];
    }

    // to String
    public String toString() {
        if (size == 0) {
            throw new IllegalStateException("Stack is Empty");
        }
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < size; i++) {
            bf.append(a[i] + " ");
        }
        return bf + " ";
    }

    // equals
    public boolean Equals(ArrayStack sk) {
        if (this.a == null || sk.a == null) {
            return false;
        }
        if (this.size != sk.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (!this.a[i].equals(sk.a[i])) {
                return false;
            }
        }
        return true;
    }

    // resize
    public void Resize() {
        Object[] aa = new Object[2 * a.length];// create a new array double the length of a so we don't have to run
                                               // resize code again and again
        for (int i = 0; i < a.length; i++) { // traverses a's elements
            aa[i] = a[i];// copies elements of a in aa
        }
        a = aa; // old array a is now new array aa so a has capacity 0f 2*a.length
    }

    // bottom element
    public Object Bottom() {
        if (size == 0) {
            throw new IllegalStateException("Stack is Empty");
        }
        return a[0];
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] instanceof Integer) {
                sum += (Integer) a[i];
            }
        }
        return sum;
    }

    public boolean searchstack(Object obj) {
        for (int i = 0; i < size; i++) {
            if (a[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public void replacestackelement(Object oldObj, Object newObj) {
        for (int i = 0; i < size; i++) {
            if (a[i].equals(oldObj)) {
                a[i] = newObj;
                return;
            }
        }
    }

    public void deleteStackElement(Object obj) {
        for (int i = 0; i < size; i++) {
            if (a[i].equals(obj)) {
                for (int j = i; j < size - 1; j++) {
                    a[j] = a[j + 1];
                }
                a[size - 1] = null;
                size--;
                return;
            }
        }
    }

    public void ReverseStackArray() {
        int start = 0;
        int end = size - 1;

        while (start < end) {
            Object temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }
    }

    public void Merge(ArrayStack sk) {

        for (int i = 0; i < sk.size; i++) {
            Push(sk.a[i]);
        }
    }

    public ArrayStack SubArrayStack(int start, int end) {

        ArrayStack sub = new ArrayStack(end - start + 1);

        for (int i = start; i <= end; i++) {
            sub.Push(a[i]);
        }

        return sub;
    }

    public Object midelemet() {
        if (size == 0) {
            throw new IllegalStateException("Stack is Empty");
        }
        int mid = size / 2;
        return a[mid];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.Push(1);
        stack.Push(2);
        stack.Push(3);
        System.out.println("Stack1: " + stack.toString());
        System.out.println("Size: " + stack.Size());
        System.out.println("Peek: " + stack.Peek());
        System.out.println("Pop: " + stack.Pop());
        System.out.println("Stack1 after pop: " + stack.toString());

        // methods implemented
        System.out.println("Bottom Element: " + stack.Bottom());
        System.out.println("Middle Element: " + stack.midelemet());
        System.out.println("Sum of Elements: " + stack.sum());
        System.out.println("Search for 2: " + stack.searchstack(2));
        stack.replacestackelement(2, 5);
        System.out.println("Stack1 after replacement: " + stack.toString());
        stack.deleteStackElement(5);
        System.out.println("Stack1 after deletion: " + stack.toString());
        stack.ReverseStackArray();
        System.out.println("Stack1 after reversal: " + stack.toString());
        ArrayStack subStack = stack.SubArrayStack(0, 2);
        System.out.println("Sub-stack: " + subStack.toString());

        ArrayStack stack2 = new ArrayStack(5);
        stack2.Push(40);
        stack2.Push(50);
        stack.Merge(stack2);
        System.out.println("Merged Stack: " + stack.toString());
    }

}