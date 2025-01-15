public class E03_BinaryTreeMirror {
    static class Node {
        int value;
        Node left, right;
        
        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }
    
    public static Node mirrorTree(Node root) {
        if (root == null) return null;
        
        Node left = mirrorTree(root.left);
        Node right = mirrorTree(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }
}