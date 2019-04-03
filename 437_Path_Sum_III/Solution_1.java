public class Solution_1 {

//    Runtime: 11 ms, faster than 73.34% of Java online submissions for Path Sum III.
//    Memory Usage: 42.7 MB, less than 10.00% of Java online submissions for Path Sum III.
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        res = inner_path_sum(root, sum);

        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);

        return res;
    }

    private int inner_path_sum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int path_sum = 0;
        if (root.val == sum) {
            path_sum++;
        }

        path_sum += inner_path_sum(root.left, sum - root.val);
        path_sum += inner_path_sum(root.right, sum - root.val);

        return path_sum;
    }
}
