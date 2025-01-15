public class E08_MedianFinder {
    private java.util.PriorityQueue<Integer> small;
    private java.util.PriorityQueue<Integer> large;
    
    public E08_MedianFinder() {
        small = new java.util.PriorityQueue<>((a, b) -> b - a);
        large = new java.util.PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        }
        return (small.peek() + large.peek()) / 2.0;
    }
}