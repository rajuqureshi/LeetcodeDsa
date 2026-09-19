class Solution {
    public void inorder(TreeNode root,TreeNode[] prev,boolean[] flag){
        if(root==null) return;
        inorder(root.left,prev,flag);
        if(prev[0]!=null){
            if(root.val<=prev[0].val){
                flag[0] = false;
            }
        }
        prev[0] = root;
        inorder(root.right,prev,flag);
    }
    public boolean isValidBST(TreeNode root) {
        TreeNode[] prev = new TreeNode [1];
        boolean[] flag = new boolean []{true};
        inorder(root,prev,flag);
        return flag[0];
    }
}