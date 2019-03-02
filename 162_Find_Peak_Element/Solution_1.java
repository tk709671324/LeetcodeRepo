public class Solution_1 {

    public int findPeakElement(int[] nums) {

//        Runtime: 2 ms, faster than 100.00% of Java online submissions for Find Peak Element.
//        Memory Usage: 39.9 MB, less than 5.19% of Java online submissions for Find Peak Element.

        if (nums.length == 1) {
            return 0;
        }
        if (nums[1] < nums[0]) {
            return 0;
        }

        if (nums[nums.length - 2] < nums[nums.length - 1]) {
            return nums.length - 1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //mid 周围有四种情况： 上升趋势、下降趋势、mid为谷底、mid为peak
            if (nums[mid] > nums[mid - 1]) {
                if (nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] < nums[mid + 1]) {
                    //谷底
                    if (nums[mid + 2] > nums[mid + 1]) {
                        start = mid + 1;
                    } else {
                        return mid + 1;
                    }
                } else {
                    end = mid;
                }
            }
        }

        return nums[start] > nums[end] ? start : end;
    }
}
