public class Solution_2 {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
//    Memory Usage: 40.5 MB, less than 5.01% of Java online submissions for Maximum Depth of Binary Tree.

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
