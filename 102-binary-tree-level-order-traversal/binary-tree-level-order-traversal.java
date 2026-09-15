/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int levels(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(levels(root.left),levels(root.right));
    }
    public void nThLevel(TreeNode root,int level,List<List<Integer>> ans){
        if(root==null) return;
        ans.get(level).add(root.val);
        nThLevel(root.left,level+1,ans);
        nThLevel(root.right,level+1,ans);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        int n = levels(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            List<Integer> list = new ArrayList<>();
            ans.add(list);
        }
        nThLevel(root,0,ans);
        return ans;
    }
}