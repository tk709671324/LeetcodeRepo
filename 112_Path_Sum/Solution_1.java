public class Solution_1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (isLeave(root)) {
            return sum == root.val;
        }

        int need = sum - root.val;
        boolean leftHas = hasPathSum(root.left, need);
        boolean rightHas = hasPathSum(root.right, need);

        return leftHas || rightHas;
    }

    private boolean isLeave(TreeNode node) {
        if (node == null) {
            return false;
        }

        if (node.left == null && node.right == null) {
            return true;
        }
        else {
            return false;
        }
    }
}
