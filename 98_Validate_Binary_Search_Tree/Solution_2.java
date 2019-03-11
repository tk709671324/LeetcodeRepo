import java.util.Stack;

public class Solution_2 {
    //非递归方法
//    Runtime: 4 ms, faster than 6.74% of Java online submissions for Validate Binary Search Tree.
//    Memory Usage: 40.6 MB, less than 5.01% of Java online submissions for Validate Binary Search Tree.
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        TreeNode lastNode = null;

        while (!stack.isEmpty()) {
            //执行一次中序遍历的中间节点的访问；
            TreeNode node = stack.peek(); //stack中最后一个是当前正在执行中序遍历的节点
            if (lastNode != null && lastNode.val >= node.val) {
                return false;
            }
            lastNode = node;//完成比较
            //该访问该节点的右值了
            if (node.right == null) {
                //node的右子节点为空，完成本次中序遍历
                node = stack.pop();
                while (stack.isEmpty() && node == stack.peek().right) {
                    //将执行下一个节点的中序遍历，如果上一个节点就是该节点的右节点的话，表示该节点的中序遍历结束
                    node = stack.pop();
                }
            } else {
                //右子节点存在的情况下
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }

        return true;
    }
}
