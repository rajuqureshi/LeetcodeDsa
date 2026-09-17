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
    public int helper(TreeNode root,long sum){
        if(root==null) return 0;
        int count = 0;
        if((long)root.val==sum) count++;
       return count+ helper(root.left,sum-(long)(root.val))+ helper(root.right,sum-(long)(root.val));
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int count = helper(root,(long)targetSum);
        count+= pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
        return count;
    }
}