
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int lineSum(TreeNode root){
        if(root==null) return 0;
        int leftSum = lineSum(root.left);
        int rightSum = lineSum(root.right);
        int pathSum = root.val;
        if(leftSum>0) pathSum+=leftSum;
        if(rightSum>0) pathSum+=rightSum;
        maxSum = Math.max(maxSum,pathSum);
        return root.val+Math.max(0,Math.max(leftSum,rightSum));
    }
    public int maxPathSum(TreeNode root) {
        lineSum(root);
        return maxSum;
    }
}