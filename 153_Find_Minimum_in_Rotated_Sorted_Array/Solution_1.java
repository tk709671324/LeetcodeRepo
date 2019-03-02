public class Solution_1 {
    public int findMin(int[] nums) {

//        Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
//        Memory Usage: 36.6 MB, less than 71.99% of Java online submissions for Find Minimum in Rotated Sorted Array.
        if (nums.length == 1) {
            return nums[0];
        }
        //数组分为两部分， 左边上升部分所有值都比右边都大

        int start = 0;
        int end = nums.length - 1;
        if (nums[end] > nums[start]) {
            //如果没有翻转则直接返回最小值
            return nums[start];
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[start]) {
                //在上升部分
                start = mid;
            } else {
                //在下降部分
                end = mid;
            }
        }

        return nums[end];
    }
}
