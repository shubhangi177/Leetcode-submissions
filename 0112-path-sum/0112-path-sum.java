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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        if(root == null){
            return false;
        }

        while(root.left == null && root.right == null){
            return targetSum-root.val == 0;
        }
        targetSum-=root.val;
        return hasPathSum(root.left, targetSum)|| hasPathSum(root.right , targetSum);
    }
}