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
    public TreeNode invertTree(TreeNode root) {
        // TC: O(n), SC: O(1)
        // Base case:
        // If tree/subtree is empty, nothing to invert.
        if (root == null) {
            return root;
        }

        // Step 1: Swap the left and right child of current node.
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // Step 2: Invert the left subtree.
        // (After swapping, this is the original right subtree.)
        invertTree(root.left);

        // Step 3: Invert the right subtree.
        // (After swapping, this is the original left subtree.)
        invertTree(root.right);

        // Return the root of the inverted tree.
        return root;
    }
}
