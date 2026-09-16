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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Push all left children of the current node to the stack
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Current is null, so pop the top item from the stack
            current = stack.pop();
            result.add(current.val); // Process the node

            // Move to the right subtree
            current = current.right;
        }

        return result;
    }
}