

public class Solution_1 {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Closest Binary Search Tree Value.
//    Memory Usage: 38.3 MB, less than 87.85% of Java online submissions for Closest Binary Search Tree Value.
    public int closestValue(TreeNode root, double target) {

        if (root.val == target) return root.val;

        if (root.val > target) {
            if (root.left == null) {
                return root.val;
            }
            int leftRes = closestValue(root.left, target);
            return (Math.abs(root.val - target) < Math.abs(leftRes - target)) ?
                    root.val : leftRes;
        } else {
            if (root.right == null) {
                return root.val;
            }
            int rightRes = closestValue(root.right, target);
            return (Math.abs(root.val - target) < Math.abs(rightRes - target)) ?
                    root.val : rightRes;
        }
    }
}
