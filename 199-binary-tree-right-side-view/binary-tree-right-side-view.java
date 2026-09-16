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
    public int level(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(level(root.left),level(root.right));
    }
    public void nThLevel(TreeNode root,int cur,int level,int[] arr){
        if(root==null) return;
        if(cur==level){
            arr[cur]=root.val;
            return;
        }
        nThLevel(root.left,cur+1,level,arr);
        nThLevel(root.right,cur+1,level,arr);
    }

    public void levelOrder(TreeNode root,int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            nThLevel(root,0,i,arr);
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        int n = level(root);
        int[] arr = new int[n];
        levelOrder(root,arr);
        List<Integer> ans =new ArrayList<>();
        for(int i : arr) ans.add(i);
        return ans;
    }
}