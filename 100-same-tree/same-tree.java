
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        // boolean ans1 = isSameTree(p.left,q.left);

        // if(ans1==false) return false;
        // boolean ans2 = isSameTree(p.right,q.right);
        // if(ans2=false) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}