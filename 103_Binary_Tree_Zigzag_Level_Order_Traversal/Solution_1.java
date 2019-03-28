public class Solution_1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean startLeft = true; //当前层是从左向右遍历
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new LinkedList<>();

            for (int i = 0; i < size; ++i) {
                //先添加孩子
                TreeNode addChild = queue.get(size - 1 - i);
                if (startLeft) {
                    if (addChild.right != null) queue.add(addChild.right);
                    if (addChild.left != null) queue.add(addChild.left);
                } else {
                    if (addChild.left != null) queue.add(addChild.left);
                    if (addChild.right != null) queue.add(addChild.right);
                }
            }

            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.remove(0);
                curLevel.add(cur.val);
            }
            startLeft = !startLeft;
            res.add(curLevel);
        }

        return res;
    }
}
