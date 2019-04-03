public class Solution_2 {
    //迭代方法
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
//    Memory Usage: 35.7 MB, less than 43.99% of Java online submissions for Invert Binary Tree.

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode left = cur.left;
            TreeNode right = cur.right;

            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }

            cur.left = right;
            cur.right = left;
        }

        return root;
    }
}
