class Solution {
    public int levels(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int leftLevel = levels(root.left);
        int rightLevel = levels(root.right);
        if(Math.abs(leftLevel-rightLevel)>1) return false;
        // int leftHeight = leftLevel-1;
        // int rightHeight = rightLevel -1;
        // if(Math.abs(leftHeight-rightHeight)==1 || Math.abs(leftHeight-rightHeight)==0) return true;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}