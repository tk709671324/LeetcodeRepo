public class Solution_2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> node_queue = new LinkedList<>();
        Queue<Integer> need_queue = new LinkedList<>();
        node_queue.offer(root);
        need_queue.offer(sum);
        TreeNode cur;
        int need;
        while (!node_queue.isEmpty()) {
            cur = node_queue.poll();
            need = need_queue.poll();

            if (cur.left == null && cur.right == null && cur.val == need) {
                return true;
            }

            if (cur.left != null) {
                node_queue.offer(cur.left);
                need_queue.offer(need - cur.val);
            }

            if (cur.right != null) {
                node_queue.offer(cur.right);
                need_queue.offer(need - cur.val);
            }
        }

        return false;
    }
}
