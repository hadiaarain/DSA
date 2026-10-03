public class Array_2D {

    public void print2D(int[][] arr, int i, int j) {

        if (i == arr.length) {
            return;
        }

        if (j == arr[i].length) {
            System.out.println();
            print2D(arr, i + 1, 0);
            return;
        }

        System.out.print(arr[i][j] + " ");
        print2D(arr, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Array_2D obj = new Array_2D();
        obj.print2D(arr, 0, 0);
    }
}