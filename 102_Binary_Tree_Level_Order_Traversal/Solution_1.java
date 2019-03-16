import java.util.*;

public class Solution_1 {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
//    Memory Usage: 37.2 MB, less than 91.78% of Java online submissions for Binary Tree Level Order Traversal.
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList();
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        List<List<Integer>> res = new LinkedList();

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new LinkedList();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                curLevel.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }

            res.add(curLevel);
        }
        return res;
    }
}
