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
    // Stores the maximum diameter found so far.
    // Diameter = number of edges in the longest path between any two nodes.
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // TC: O(N) -> visit every node once
        // SC: O(H) -> recursion stack (H = height of tree)

        // Calculate heights of all subtrees while updating diameter.
        height(root);

        return diameter;
    }

    private int height(TreeNode root) {
        // Base case:
        // Empty subtree has height 0.
        if (root == null) {
            return 0;
        }

        // Height of left subtree.
        int left = height(root.left);

        // Height of right subtree.
        int right = height(root.right);

        /*
         * Longest path passing through current node:
         *
         * left subtree -> current node -> right subtree
         *
         * Number of edges in this path = left + right
         *
         * Update global diameter if this path is larger.
         */
        diameter = Math.max(diameter, left + right);

        /*
         * Return height of current subtree.
         *
         * Height = 1 (current node)
         *        + max(left subtree height, right subtree height)
         */
        return 1 + Math.max(left, right);
    }
}
