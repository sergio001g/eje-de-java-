public class E15_TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        java.util.Map<Integer, Integer> frequencyMap = new java.util.HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        java.util.PriorityQueue<Integer> heap = new java.util.PriorityQueue<>(
            (a, b) -> frequencyMap.get(b) - frequencyMap.get(a)
        );
        
        heap.addAll(frequencyMap.keySet());
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        
        return result;
    }
}