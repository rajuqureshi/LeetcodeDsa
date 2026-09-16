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
    // public void help(TreeNode root,List<Integer> ans){
    //     if(root==null) return;
    //     help(root.left,ans);
    //     help(root.right,ans);
    //     ans.add(root.val);
    // }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode>st = new Stack<>();
        if(root!=null) st.push(root);
        while(st.size()>0){
            TreeNode temp = st.peek();
            st.pop();
            list.add(temp.val);
            if(temp.left!=null) st.push(temp.left);
            if(temp.right!=null) st.push(temp.right);

        }
        System.out.println(list);
         Collections.reverse(list);
        return list;
    }
}