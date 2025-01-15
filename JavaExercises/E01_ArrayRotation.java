public class E01_ArrayRotation {
    public static int[] rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = arr[i];
        }
        return result;
    }
}