public class max_min {
    public int max(int[] a, int index) {

        // Base case
        if (index == a.length - 1) {
            return a[index];
        }

        // Recursive call
        int maxRest = max(a, index + 1);

        // Compare current element with maximum of remaining array
        if (a[index] > maxRest) {
            return a[index];
        } else {
            return maxRest;
        }
    }

    public int min(int[] a, int index) {

        // Base case
        if (index == a.length - 1) {
            return a[index];
        }

        int minRest = min(a, index + 1);

        if (a[index] < minRest) {
            return a[index];
        } else {
            return minRest;
        }
    }

    public static void main(String[] args) {
        max_min obj = new max_min();
        int[] arr = { 3, 5, 2, 8, 1 };
        int maxValue = obj.max(arr, 0);
        System.out.println("Maximum value in the array: " + maxValue);

        int minValue = obj.min(arr, 0);
        System.out.println("Minimum value in the array: " + minValue);
    }
}