class Solution {
    public void helper(TreeNode root,String s,List<String>ans){
        if(root==null) return;
        String a = Integer.toString(root.val);
        if(root.left==null && root.right==null){
            s+=a;
            ans.add(s);
        }
        helper(root.left,s+a+"->",ans);
        helper(root.right,s+a+"->",ans);

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root,"",ans);
        return ans;
    }
}