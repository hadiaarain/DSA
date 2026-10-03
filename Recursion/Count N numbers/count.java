 public class count{

    public void count(int n) {

        if (n == 0) {
            return;
        }

        count(n - 1);

        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 20; // You can change this value to count up to a different number
        count obj = new count();
        obj.count(n);
    }
}