public class Solution_2 {

//    Runtime: 1 ms, faster than 84.84% of Java online submissions for Balanced Binary Tree.
//    Memory Usage: 39.4 MB, less than 68.82% of Java online submissions for Balanced Binary Tree.
    class ResultType {
        public int depth;
        public boolean isBalanced;

        ResultType(int depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root).isBalanced;
    }

    private ResultType maxDepth(TreeNode node) {
        if (node == null) {
            return new ResultType(0, true);
        }

        ResultType left = maxDepth(node.left);
        ResultType right = maxDepth(node.right);

        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(-1, false);
        }

        if (Math.abs(left.depth - right.depth) > 1) {
            return new ResultType(-1, false);
        }

        return new ResultType(Math.max(left.depth, right.depth) + 1, true);
    }
}
