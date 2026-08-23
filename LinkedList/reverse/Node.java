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

    public int size(Node a) {
        int size = 0;
        for (Node i = a; i != null; i = i.next) {
            size++;
        }
        return size;
    }

    public void rev(Node a) {
        int c = 0;
        int[] arr = new int[size(a)];
        System.out.println("Original Array: ");
        for (Node i = a; i != null; i = i.next) {
            System.out.println(arr[c++] = i.data);
        }

        System.out.println();
        System.out.println("Rev Array: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(10);
        n1.next = new Node(20);
        n1.next.next = new Node(30);

        n1.rev(n1);

    }
}