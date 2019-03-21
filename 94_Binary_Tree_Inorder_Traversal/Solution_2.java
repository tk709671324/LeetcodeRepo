public class Solution_2 {

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
//    Memory Usage: 36.2 MB, less than 18.37% of Java online submissions for Binary Tree Inorder Traversal.
    //不使用栈的迭代遍历方法
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList();
        }

        List<Integer> list = new LinkedList<>();
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left == null) {
                list.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while ((pre.right != null) && (pre.right != cur)) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    list.add(cur.val);
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }

        return list;
    }
}
