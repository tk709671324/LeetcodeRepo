public class Solution_1 {


//    Runtime: 1 ms, faster than 85.13% of Java online submissions for Subsets.
//    Memory Usage: 38.4 MB, less than 12.66% of Java online submissions for Subsets.
    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return new LinkedList();
        }

        List<List<Integer>> res = new LinkedList<>();
        dfs(nums, 0, new LinkedList<Integer>(), res);
        return res;

    }

    private void dfs(int[] nums,
                     int index,
                     List<Integer> subset,
                     List<List<Integer>> res) {
        //讨论index的数字在或不在组合中出现的情况。
        //未剪枝

        if (index == nums.length) {
            //已经计算完毕
            res.add(new LinkedList(subset));
            return;
        }

        //当index位置的数在组合中出现的时候
        subset.add(nums[index]);
        dfs(nums, index + 1, subset, res);

        //当index未知的数在组合中不出现的时候
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset, res);
    }
}
