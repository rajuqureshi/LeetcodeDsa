class Solution {
    int maxDi;
    public int levels(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(levels(root.left),levels(root.right));
    }

    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        int dia = levels(root.left) + levels(root.right);
        maxDi= Math.max(dia,maxDi);
        helper(root.left);
        helper(root.right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDi=0;
        helper(root);
        return maxDi;
    }
}