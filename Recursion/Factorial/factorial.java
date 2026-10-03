public class factorial {

    public int factorial(int n) {

        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        factorial obj = new factorial();
        System.out.println(obj.factorial(5));
    }
}