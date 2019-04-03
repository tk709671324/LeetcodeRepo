public class Solution_1 {

    private int MAX_PATH_SUM = Integer.MIN_VALUE;

    //计算经过这个节点下的路径可以大成的最大sum
    //全局变量记录最大值

    //max_gain()计算这个绩点到其某个叶子的路径的最大值
    //同时计算该节点为根的子树下并经过该节点最大路径sum
    //计算每个内部即可遍历所有可能的路径
    private int max_gain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left_max = Math.max(max_gain(node.left), 0);
        int right_max = Math.max(max_gain(node.right), 0);

        int inside_path_max_sum = left_max + node.val + right_max;
        MAX_PATH_SUM = Math.max(MAX_PATH_SUM, inside_path_max_sum);

        return Math.max(left_max, right_max) + node.val;
    }
    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return MAX_PATH_SUM;
    }
}
