class Solution {
    TreeNode prev = null;
    boolean flag = true;
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null){
            if(root.val<=prev.val){
                flag = false;
            }
        }
        prev = root;
        inorder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return flag;
    }
}