import java.util.TreeSet;

public class Solution_1 {


//    Runtime: 24 ms, faster than 62.74% of Java online submissions for Contains Duplicate III.
//    Memory Usage: 38.8 MB, less than 100.00% of Java online submissions for Contains Duplicate III.

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length <= 1 || t < 0 || k <= 0) {
            return false;
        }

        TreeSet<Long> filter = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (filter.ceiling((long)nums[i] - (long)t) != null &&
                    filter.ceiling((long)nums[i] - (long)t) <= (long)nums[i] + (long)t) {
                return true;
            } else {
                filter.add((long)nums[i]);
                if (filter.size() == k + 1) {
                    filter.remove((long)nums[i - k]);
                }
            }
        }

        return false;

    }


    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int[] nums = {1,2147483647};
        System.out.println(solution_1.containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }



}
