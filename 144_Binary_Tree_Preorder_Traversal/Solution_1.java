public class Solution_1 {

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
//    Memory Usage: 36.1 MB, less than 69.22% of Java online submissions for Binary Tree Preorder Traversal.
    //使用栈的方法来解决
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> list = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return list;
    }
}
