class Solution {
    public void insert(TreeNode root,int value){
        if(root==null) root = new TreeNode(value);
        else if(root.val>value){
            if(root.left==null) root.left = new TreeNode(value);
           else insert(root.left,value);
        }else {
            if(root.right==null) root.right = new TreeNode(value);
            else insert(root.right,value);
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=1;i<n;i++){
            insert(root,preorder[i]);
        }
        return root;
    }
}