public class Solution_1 {

//    Runtime: 1 ms, faster than 88.42% of Java online submissions for Binary Tree Level Order Traversal II.
//    Memory Usage: 37.3 MB, less than 66.26% of Java online submissions for Binary Tree Level Order Traversal II.

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new LinkedList<>();

            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                curLevel.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            stack.push(curLevel);
        }
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            res.add(stack.pop());
        }

        return res;
    }
}
