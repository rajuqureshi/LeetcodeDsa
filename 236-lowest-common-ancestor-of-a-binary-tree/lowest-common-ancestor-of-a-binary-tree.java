/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean exist(TreeNode root,TreeNode target){
        if(root==null) return false;
        if(target==root) return true;
        return exist(root.left,target) || exist(root.right,target);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q) return root;
        if(exist(root.left,p) && exist(root.right,q)) return root;
        else if(exist(root.left,q) && exist(root.right,p)) return root;
        else if(exist(root.left,p) || exist(root.left,q)) 
        return lowestCommonAncestor(root.left,p,q);
        else return lowestCommonAncestor(root.right, p,q);
    }
}