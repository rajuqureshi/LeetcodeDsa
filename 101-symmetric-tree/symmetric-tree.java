class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        // Use a helper function to compare the left and right subtrees
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode node1, TreeNode node2) {
        // If both nodes are null, they are symmetric
        if (node1 == null && node2 == null) {
            return true;
        }
        // If only one is null, they are not symmetric
        if (node1 == null || node2 == null) {
            return false;
        }
        // Check if current values match, and then recursively check the outer and inner children
        return (node1.val == node2.val) 
            && isMirror(node1.left, node2.right) 
            && isMirror(node1.right, node2.left);
    }
}