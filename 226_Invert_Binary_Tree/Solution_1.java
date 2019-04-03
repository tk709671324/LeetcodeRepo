public class Solution_1 {

    Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
    Memory Usage: 35.6 MB, less than 66.40% of Java online submissions for Invert Binary Tree.

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            root.left = invertTree(root.left);
        }
        if (root.right != null) {
            root.right = invertTree(root.right);
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
