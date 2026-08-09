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

        helper(root, result, sb);
        return result;
    }
    private void helper(TreeNode root, List<String> result, StringBuilder sb){
        if(root == null){
            return;
        }
        int len = sb.length();
        sb.append(root.val);

        if(root.left == null && root.right == null){
            result.add(sb.toString());
        }else{
            sb.append("->");
            helper(root.left, result, sb);
            helper(root.right, result, sb);
        }
        sb.setLength(len);
    }
}