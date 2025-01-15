public class E20_SegmentTree {
    private int[] tree;
    private int[] nums;
    
    public E20_SegmentTree(int[] nums) {
        this.nums = nums;
        tree = new int[4 * nums.length];
        if (nums.length > 0) buildTree(0, 0, nums.length - 1);
    }
    
    private void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        
        int mid = start + (end - start) / 2;
        buildTree(2 * node + 1, start, mid);
        buildTree(2 * node + 2, mid + 1, end);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    
    public void update(int index, int val) {
        updateTree(0, 0, nums.length - 1, index, val);
    }
    
    private void updateTree(int node, int start, int end, int index, int val) {
        if (start == end) {
            nums[index] = val;
            tree[node] = val;
            return;
        }
        
        int mid = start + (end - start) / 2;
        if (index <= mid) {
            updateTree(2 * node + 1, start, mid, index, val);
        } else {
            updateTree(2 * node + 2, mid + 1, end, index, val);
        }
        
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    
    public int sumRange(int left, int right) {
        return queryTree(0, 0, nums.length - 1, left, right);
    }
    
    private int queryTree(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && right >= end) return tree[node];
        
        int mid = start + (end - start) / 2;
        return queryTree(2 * node + 1, start, mid, left, right) +
               queryTree(2 * node + 2, mid + 1, end, left, right);
    }
}