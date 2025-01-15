public class E02_SubarraySum {
    public static boolean findSubarrayWithSum(int[] arr, int targetSum) {
        int currentSum = 0;
        int start = 0;
        
        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];
            while (currentSum > targetSum && start < end) {
                currentSum -= arr[start];
                start++;
            }
            if (currentSum == targetSum) return true;
        }
        return false;
    }
}