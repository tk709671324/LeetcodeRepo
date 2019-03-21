public class Solution_1 {

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
//    Memory Usage: 36.2 MB, less than 31.52% of Java online submissions for Binary Tree Inorder Traversal.
    //使用栈来解决
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> list = new LinkedList<>();

        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();//对该节点进行遍历
            if (cur.left != null) {
                stack.push(cur.left);
                cur.left = null;
                continue;
            } else {
                list.add(cur.val);
                stack.pop();
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            }
        }

        return list;
    }
}
