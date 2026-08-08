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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode n1, TreeNode n2) {

        // Both nodes are null
        if (n1 == null && n2 == null) {
            return true;
        }

        // One is null, the other isn't
        if (n1 == null || n2 == null) {
            return false;
        }

        // Values must be equal
        if (n1.val == n2.val) {
            return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
        }

        return false;
    }
}