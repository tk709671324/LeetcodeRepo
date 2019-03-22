public class Solution_1 {

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
//    Memory Usage: 36.2 MB, less than 35.26% of Java online submissions for Binary Tree Postorder Traversal.
public class Solution_1 {

    //    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
//    Memory Usage: 36.2 MB, less than 35.26% of Java online submissions for Binary Tree Postorder Traversal.
    //用栈解决二叉树的遍历 -- 需要一个变量来记载上一个弹出的节点
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList();
        }

        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();

            if (cur.left == null && cur.right == null) {
                list.add(cur.val);
                pre = stack.pop();
                continue;
            }

            if (pre != null && cur.right == pre) {
                list.add(cur.val);
                pre = stack.pop();
                continue;
            }

            if (pre != null && cur.left == pre) {
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    list.add(cur.val);
                    pre = stack.pop();
                }
                continue;
            }

            if (cur.left != null) {
                stack.push(cur.left);
            } else {
                stack.push(cur.right);
            }

        }

        return list;
    }
}

}
