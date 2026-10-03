public class LinkedArrayTraverse {

    public class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void TraverseLinkedArray(Node[] a, int index, Node head) {

        // Base case
        if (index == a.length) {
            return;
        }

        // If head is null, take the node from the array
        if (head == null) {
            head = a[index];
        }

        // Print current node
        System.out.println(head.data);

        // If there is another node in the linked list
        if (head.next != null) {

            TraverseLinkedArray(a, index, head.next);
        }

        // Move to next array element
        else {

            TraverseLinkedArray(a, index + 1, null);
        }
    }

    public static void main(String[] args) {

        LinkedArrayTraverse obj = new LinkedArrayTraverse();

        // Create nodes
        Node n1 = obj.new Node(1);
        Node n2 = obj.new Node(2);
        Node n3 = obj.new Node(3);
        Node n4 = obj.new Node(4);
        Node n5 = obj.new Node(5);

        // Link nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // Store linked-list head in array
        Node[] array = { n1 };

        // Traverse
        obj.TraverseLinkedArray(array, 0, null);
    }
}