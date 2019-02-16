import java.util.HashMap;

public class Solution_1 {

//    Runtime: 9 ms, faster than 83.70% of Java online submissions for Contains Duplicate II.
//    Memory Usage: 40.5 MB, less than 100.00% of Java online submissions for Contains Duplicate II.

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && i - index <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }
}
