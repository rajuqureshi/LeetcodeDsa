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
    public int levels(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(levels(root.left),levels(root.right));
    }
    public void nThLevel(TreeNode root,int cur,int level,List<Integer> list,boolean leftToRight){
        if(root==null) return;
        if(cur==level){
            list.add(root.val);
            return;
        }
        if(leftToRight){
        nThLevel(root.left,cur+1,level,list,leftToRight);
        nThLevel(root.right,cur+1,level,list,leftToRight);
        } else{
        nThLevel(root.right,cur+1,level,list,leftToRight);
        nThLevel(root.left,cur+1,level,list,leftToRight);
        }
    }
    public void levelsOrder(TreeNode root,List<List<Integer>> ans){
        int levels = levels(root);
        boolean flag = true;
        for(int i=1;i<=levels;i++){
            ArrayList<Integer> list = new ArrayList<>();
            nThLevel(root,1,i,list,flag);
            ans.add(list);
            flag = !flag;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelsOrder(root,ans);
        return ans;
    }
}


