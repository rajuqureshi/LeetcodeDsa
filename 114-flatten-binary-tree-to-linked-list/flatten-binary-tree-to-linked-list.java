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
    // public List<TreeNode> preOrder(TreeNode root){
    //     List<TreeNode> help = new ArrayList<>();
    //     if(root==null) return new ArrayList<>();
    //     help.add(root);
    //     preOrder(root.left);
    //     preOrder(root.right);
    //     return help;
    // }
    public List<TreeNode> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<TreeNode> ans = new ArrayList<>();
        if(root!=null) stack.push(root);
        while(stack.size()>0){
            TreeNode temp = stack.peek();
            stack.pop();
            ans.add(temp);
            if(temp.right!=null) stack.push(temp.right);
            if(temp.left!=null) stack.push(temp.left);
        }
        return ans;
    }
    public void flatten(TreeNode root) {
        List<TreeNode> ans = preorderTraversal(root);
        for(int i=0;i<ans.size()-1;i++){
            ans.get(i).right = ans.get(i+1);
            ans.get(i).left = null;
        }
    }
}