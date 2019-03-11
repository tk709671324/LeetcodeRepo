public class Solution_1 {
    class ResultType {
        public boolean isBST;
        public TreeNode minNode;
        public TreeNode maxNode;
        ResultType(boolean isBST) {
            this.isBST = isBST;
            this.minNode = null;
            this.maxNode = null;
        }
    }
    public boolean isValidBST(TreeNode root) {
        return divideandConquer(root).isBST;
    }

    private ResultType divideandConquer(TreeNode node) {
        if (node == null) {
            return new ResultType(true);
        }

        ResultType left = divideandConquer(node.left);
        ResultType right = divideandConquer(node.right);

        if (!left.isBST || !right.isBST) {
            return new ResultType(false);
        }

        if (left.maxNode != null && left.maxNode.val >= node.val) {
            return new ResultType(false);
        }
        if (right.minNode != null && right.minNode.val <= node.val) {
            return new ResultType(false);
        }

        ResultType result = new ResultType(true);
        result.minNode = left.minNode == null ? node : left.minNode;
        result.maxNode = right.maxNode == null ? node : right.maxNode;
        return result;
    }
}
