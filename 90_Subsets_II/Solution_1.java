public class Solution_1 {

//    Runtime: 1 ms, faster than 100.00% of Java online submissions for Subsets II.
//    Memory Usage: 38.4 MB, less than 42.25% of Java online submissions for Subsets II.
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            res.add(new LinkedList());
            return res;
        }
        Arrays.sort(nums);
        backtrack(nums, 0, new LinkedList<Integer>(), res);
        return res;
    }


    //数组中从index开始的所有组合
    private void backtrack(int[] nums,
                           int index,
                           List<Integer> subset,
                           List<List<Integer>> res) {
        res.add(new LinkedList(subset));

        for (int i = index; i < nums.length; ++i) {
            //判断是否重复
            if (i != 0 && nums[i] == nums[i - 1] && i > index) {
                //为什么需要i > index
                //定义为求从index开始的所有组合，则不考虑index之前的数的情况，不需要判断是否和index - 1 相等
                //会产生重复的情况是，选择的index到末尾之间出现重复的元素，这样的元素如果重复选择的话，就会产生重复的组合。
                continue;
            }
            subset.add(nums[i]);
            backtrack(nums, i + 1, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
