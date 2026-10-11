
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node == null) {
                result.append("N,");
                continue;
            }

            result.append(node.val).append(",");

            queue.offer(node.left);
            queue.offer(node.right);
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {

            TreeNode node = queue.poll();

            // Left child
            if (!values[i].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.left);
            }
            i++;

            // Right child
            if (i < values.length && !values[i].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }
}
