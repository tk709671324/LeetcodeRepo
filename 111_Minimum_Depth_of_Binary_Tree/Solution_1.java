/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import javafx.util.Pair;
class Solution_1 {

    //使用迭代的方法
//    Runtime: 6 ms, faster than 7.66% of Java online submissions for Minimum Depth of Binary Tree.
//    Memory Usage: 41.1 MB, less than 5.07% of Java online submissions for Minimum Depth of Binary Tree.

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int min_depth = Integer.MAX_VALUE;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> curPair = stack.pop();
            TreeNode curNode = curPair.getKey();
            int curDepth = curPair.getValue();


            if (curNode.left != null) {
                stack.push(new Pair(curNode.left, curDepth + 1));
            }
            if (curNode.right != null) {
                stack.push(new Pair(curNode.right, curDepth + 1));
            }
            if (curNode.right == null && curNode.left == null) {
                min_depth = Math.min(min_depth, curDepth);
            }
        }

        return min_depth;
    }
}