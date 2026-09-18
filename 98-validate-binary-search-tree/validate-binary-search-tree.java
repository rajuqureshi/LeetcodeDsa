class Solution {
    public Long maxLong(TreeNode root){
        if(root==null) return Long.MIN_VALUE;
        return Math.max((long)(root.val),Math.max(maxLong(root.left),maxLong(root.right)));
    }

public Long minLong(TreeNode root){
        if(root==null) return Long.MAX_VALUE;
        return Math.min((long)(root.val),Math.min(minLong(root.left),minLong(root.right)));
    }
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if((long)root.val>=minLong(root.right)) return false;
        else if((long)root.val<=maxLong(root.left)) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
}