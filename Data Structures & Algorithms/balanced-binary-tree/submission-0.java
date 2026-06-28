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

    // Returns true if the tree is balanced.
    public boolean isBalanced(TreeNode root) {
        // TC: O(n), SC: O(h)
        // height() returns -1 when an unbalanced subtree is found.
        return height(root) != -1;
    }

    private int height(TreeNode root) {

        // Empty tree has height 0.
        if (root == null) {
            return 0;
        }

        // Recursively get heights of left and right subtrees.
        int left = height(root.left);
        int right = height(root.right);

        // If left subtree is already unbalanced,
        // propagate the failure upward.
        if (left == -1) {
            return -1;
        }

        // If right subtree is already unbalanced,
        // propagate the failure upward.
        if (right == -1) {
            return -1;
        }

        // Current node is unbalanced if height difference > 1.
        if (Math.abs(left - right) > 1) {
            return -1;
        }

        // Return height of current subtree.
        return 1 + Math.max(left, right);
    }
}
