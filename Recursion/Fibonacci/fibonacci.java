public class fibonacci {

    public int fibonacci_(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci_(n - 1) + fibonacci_(n - 2);
    }

    public static void main(String[] args) {
        fibonacci obj = new fibonacci();
        System.out.println(obj.fibonacci_(6));
    }
}