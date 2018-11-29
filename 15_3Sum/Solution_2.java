import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_2 {

    /*
    Date : 2018/11/29
    Time : O(n^2)
    beats : 42.34%
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];

                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) { l++; }
                        while (l < r && nums[r] == nums[r - 1]) { r--; }

                        l++;
                        r--;
                    }else if (nums[l] + nums[r] < sum) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return res;
    }

}
