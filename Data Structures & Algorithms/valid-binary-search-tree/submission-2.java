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
    public boolean isValidBST(TreeNode root) {
        return validTree(root, null, null);
    }

    private boolean validTree(TreeNode node, Integer lower, Integer upper) {

        if(node == null) {
            return true;
        }

        if((lower!=null && lower >= node.val) || (upper!=null && upper <= node.val)) {
            return false;
        }

        return validTree(node.left, lower, node.val) && validTree(node.right, node.val, upper);
    }
}
