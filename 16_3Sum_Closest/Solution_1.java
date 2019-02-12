import java.util.Arrays;

public class Solution_1 {

    /**
     * O(n^2)
     * Runtime: 10 ms, faster than 86.09% of Java online submissions for 3Sum Closest.
     * Memory Usage: 38 MB, less than 0.97% of Java online submissions for 3Sum Closest.
     */

    public int threeSumClosest(int[] nums, int target) {
        assert nums.length > 2;

        int result = nums[0] + nums[1] + nums[nums.length - 1];

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                if (Math.abs(temp - target) < Math.abs(result - target)) {
                    result = temp;
                }

                if (temp > target) {
                    r--;
                } else if (temp < target) {
                    l++;
                }else {
                    return target;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(solution_1.threeSumClosest(nums, 1));
    }
}
