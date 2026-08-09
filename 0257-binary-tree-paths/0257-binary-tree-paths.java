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

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(result, root, sb);

        return result;
    }

    private void helper(List<String> result, TreeNode root, StringBuilder sb) {

        if (root == null) {
            return;
        }

        // Save the length before adding the current node.
        // We need this to BACKTRACK later.
        int len = sb.length();

        // Add current node to the path.
        sb.append(root.val);

        // A path is complete ONLY when we reach a leaf.
        if (root.left == null && root.right == null) {

            result.add(sb.toString());

        } else {

            // Current node is not a leaf, so continue the path.
            sb.append("->");

            // Explore left subtree.
            helper(result, root.left, sb);

            // Explore right subtree.
            helper(result, root.right, sb);
        }

        /*
         * BACKTRACK:
         * Remove everything added during this call.
         *
         * This allows the same StringBuilder to be reused
         * for another branch.
         */
        sb.setLength(len);
    }
}

