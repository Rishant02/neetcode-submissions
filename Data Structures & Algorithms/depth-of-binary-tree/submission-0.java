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
    public int maxDepth(TreeNode root) {
        // TC: O(n), SC: O(H)
        // Base case:
        // An empty tree has depth 0.
        if (root == null) {
            return 0;
        }

        // Get depth of left subtree.
        int leftDepth = maxDepth(root.left);

        // Get depth of right subtree.
        int rightDepth = maxDepth(root.right);

        // Current node contributes 1 level.
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
