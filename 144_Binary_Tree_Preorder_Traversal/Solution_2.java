public class Solution_2 {

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
//    Memory Usage: 36.1 MB, less than 55.92% of Java online submissions for Binary Tree Preorder Traversal.
    //非递归方法 ： 该方法的主要思想是 -- 遍历的时候将左子树的最右节点标记出来，处理完该节点后表示该处理右子树了
    //当一个节点的左子树的最右节点被标记（将右子节点设置成当前节点）后，如果再次回到这个节点，则说明左子树已经被处理完，因为：
    //左子树的最右节点是最后一个节点，处理完该节点后会根据遍历逻辑进入其右节点，此时是回到了当前节点
    //此时按照逻辑，会寻找当前节点的左子树最右节点，发现已经标记过了，则说明是左子树处理完毕
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            //cur是正在处理的节点
            if (cur.left == null) {
                list.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left; // 用pre来标记左子树最后一个处理的节点，处理完该节点后就该处理右子树了；
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    //在处理该节点的时候第一次找对应的pre
                    //开始处理该节点
                    list.add(cur.val);
                    pre.right = cur; //标记，表示开始处理左子树
                    cur = cur.left;
                } else {
                    //重新遇到了cur说明之前标记过，表示这时左子树已经处理完毕
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }

        return list;
    }
}
