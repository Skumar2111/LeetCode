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
        
        return calculateLCA(root,p,q);

    }

    public TreeNode calculateLCA(TreeNode node , TreeNode p, TreeNode q)
    {

        if(node == null)
        {
            return null;
        }

        if(node.val == p.val || node.val == q.val)
        {
            return node;
        }

        TreeNode left_LCA = calculateLCA(node.left,p,q);
        TreeNode right_LCA = calculateLCA(node.right,p,q);

        if(left_LCA != null && right_LCA != null)
        {
            return node;
        }

        return (left_LCA != null) ? left_LCA : right_LCA;

    }
}