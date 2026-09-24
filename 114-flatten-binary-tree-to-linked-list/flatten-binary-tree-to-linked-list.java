/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        // using recursion
        if(root==null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode r = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode temp = root;
        while(temp.right!=null) temp = temp.right;
        temp.right = r;

    }
}