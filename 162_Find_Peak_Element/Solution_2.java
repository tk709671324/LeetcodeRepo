public class Solution_2 {

    //因为从0开始是上升趋势，而nums.length - 1 是下降趋势，所以直接从两边往中间任意一个peak逼近就行了.
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
