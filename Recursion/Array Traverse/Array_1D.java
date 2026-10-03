public class Array_1D {

    public void print1D(int[] arr, int i) {

        if (i == arr.length) {
            return;
        }
        System.out.print(arr[i] + " ");
        print1D(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Array_1D obj = new Array_1D();
        obj.print1D(arr, 0);
    }
}