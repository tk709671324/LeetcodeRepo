public class Solution_1 {


//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
//    Memory Usage: 40.4 MB, less than 5.01% of Java online submissions for Maximum Depth of Binary Tree.

    private int depth;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        tranverse(root, 1);
        return depth;
    }

    private void tranverse(TreeNode node, int curDepth) {
        if (node == null) {
            return;
        }

        depth = Math.max(depth, curDepth);
        tranverse(node.left, curDepth + 1);
        tranverse(node.right, curDepth + 1);
    }
}
