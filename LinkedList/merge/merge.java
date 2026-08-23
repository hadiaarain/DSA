import org.w3c.dom.Node;

public class merge {
    private int data;
    private merge next;

    public merge(int data) {
        this.data = data;
        this.next = null;
    }

    public merge(int data, merge next) {
        this.data = data;
        this.next = next;
    }

    public static merge insert(merge a, int x) {
        if (a == null || a.data > x) {
            a = new merge(x, a);
            return a;
        }

        merge b = a;
        while (b.next != null) {
            if (b.next.data > x) {
                break;
            }
            b = b.next;
        }
        merge newM = new merge(x, b.next);
        b.next = newM;
        return a;

    }

    public static merge mergeit(merge a, merge b) {
        merge dummy = null;
        merge c = a;

        while (c != null) {
            dummy = insert(dummy, c.data);
            c = c.next;
        }

        c = b;
        while (c != null) {
            dummy = insert(dummy, c.data);
            c = c.next;
        }

        return dummy;
    }

    public static void print(merge head) {
        for (merge i = head; i != null; i = i.next) {
            System.out.print(i.data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        merge m1 = new merge(10);
        m1.next = new merge(20);
        m1.next.next = new merge(30);
        m1.next.next.next = new merge(40);

        merge m2 = new merge(50);
        m2.next = new merge(60);
        m2.next.next = new merge(70);
        m2.next.next.next = new merge(80);

        // merge merged = merge.mergeit(m1, m2);
        // merge.print(merged);
        System.out.println("List 1:");
        merge.print(m1);
        System.out.println("List 2:");
        merge.print(m2);

        merge merged = merge.mergeit(m1, m2);
        System.out.println("Merged List:");
        merge.print(merged);
    }
}