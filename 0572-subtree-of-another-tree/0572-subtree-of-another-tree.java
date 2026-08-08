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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If root becomes null, there is no subtree to search.
        if (root == null) {
            return false;
        }

        // Matching the value only gives us a candidate.
        // isSameTree() verifies the candidate.
        // If verification fails, we must keep searching.
        if (root.val == subRoot.val) {
            if (isSameTree(root, subRoot)) {
                return true;
            }
        }

        // Keep searching the left and right subtrees.
        // If the subtree is found on either side, return true.
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode n1, TreeNode n2) {

        // Both nodes are null -> both trees have ended here.
        if (n1 == null && n2 == null) {
            return true;
        }

        // One node is null but the other exists -> structures differ.
        if (n1 == null || n2 == null) {
            return false;
        }

        // Both nodes exist, but their values differ.
        if (n1.val != n2.val) {
            return false;
        }

        // Current nodes match, so compare their left and right subtrees.
        return isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    }
}

