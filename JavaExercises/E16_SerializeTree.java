public class E16_SerializeTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public static String serialize(TreeNode root) {
        if (root == null) return "null";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }
    
    public static TreeNode deserialize(String data) {
        java.util.Queue<String> queue = new java.util.LinkedList<>(java.util.Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    
    private static TreeNode deserializeHelper(java.util.Queue<String> queue) {
        String val = queue.poll();
        if ("null".equals(val)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }
}