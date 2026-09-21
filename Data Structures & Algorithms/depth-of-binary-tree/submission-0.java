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
        return findLength(root, 0);
    }

    private int findLength(TreeNode node, int length) {
        if(node == null) {
            return length;
        }

        length++;
        return Math.max(findLength(node.left, length), findLength(node.right, length));
    }
}
