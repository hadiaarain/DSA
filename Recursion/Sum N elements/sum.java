public class sum {
    static int sumN(int n) {

        if (n == 0) {
            return 0;
        }

        return n + sumN(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        int result = sumN(n);
        System.out.println("The sum of first " + n + " natural numbers is: " + result);
    }
}