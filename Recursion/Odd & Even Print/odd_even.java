public class odd_even {
    public void odd(int n) {
        if (n == 0) {
            return;
        }

        odd(n - 1);

        if (n % 2 != 0) {
            System.out.println(n);
        }
    }

    public void even(int n) {
        if (n == 0) {
            return;
        }

        even(n - 1);

        if (n % 2 == 0) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        odd_even obj = new odd_even();
        int n = 10; // Example input
        System.out.println("Odd numbers:");
        obj.odd(n);
        System.out.println("Even numbers:");
        obj.even(n);
    }
}