import java.util.HashSet;
import java.util.Set;

public class Solution_1 {

    //    Runtime: 14 ms, faster than 39.51% of Java online submissions for Contains Duplicate.
    //    Memory Usage: 42.3 MB, less than 100.00% of Java online submissions for Contains Duplicate.
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;

    }
}
