/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findAncestor(root, p,q, null);
    }

    private TreeNode findAncestor(TreeNode node, TreeNode p, TreeNode q, TreeNode result) {
        if(node == null) {
            return result;
        }

        if(node.val == p.val) {
            return p;
        }

        if(node.val == q.val) {
            return q;
        }

        TreeNode leftNode = findAncestor(node.left, p, q, result);
        TreeNode rightNode = findAncestor(node.right, p, q, result);

        if(leftNode!=null && rightNode!=null) {
            result = node;
        } else if (leftNode!=null) {
            result=leftNode;
        } else {
            result=rightNode;
        }

        return result;
    }
}