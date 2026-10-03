public class print {
    public void printN(int n) {
        if (n == 0) {
            return;
        }

        printN(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        print printer = new print();
        int n = 5; // You can change this value to print different numbers
        printer.printN(n);
    }
}