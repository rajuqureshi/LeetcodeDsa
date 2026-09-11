class Solution {
    int maxDi = 0;
    public int levels(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(levels(root.left),levels(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int dia = levels(root.left) + levels(root.right);
        maxDi= Math.max(dia,maxDi);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return maxDi;
    }
}