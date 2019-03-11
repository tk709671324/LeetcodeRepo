public class Solution_1 {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Balanced Binary Tree.
//    Memory Usage: 40.8 MB, less than 20.77% of Java online submissions for Balanced Binary Tree.
    private final static int NOT_BALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != NOT_BALANCED;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        if (left == NOT_BALANCED || right == NOT_BALANCED) {
            return NOT_BALANCED;
        }

        if(Math.abs(left - right) > 1) {
            return NOT_BALANCED;
        }

        return Math.max(left, right) + 1;
    }
}
