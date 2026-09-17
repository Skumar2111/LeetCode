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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> preOrderList = new ArrayList<Integer>();

        recurPreOrderTraversal(root,preOrderList);

        return preOrderList;
        

        
    }

    public void recurPreOrderTraversal(TreeNode root,List<Integer> preOrderList)
    {
        if(root == null) return;
        preOrderList.add(root.val);
        recurPreOrderTraversal(root.left, preOrderList);
        recurPreOrderTraversal(root.right, preOrderList);

    }
}