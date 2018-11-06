public class Solution_2 {
	public int minSubArrayLen(int s, int[] nums){

		/**
		 * Date : 2018/11/6
		 *
		 * beats : 99.90%
		 *
		 * time complexity : O(n)
		 */

		//采用滑动窗口的解法
		//每次循环取一个新的窗口

		int l = 0;
		int r = -1;    //因为我们不想让初始窗口包涵任何元素
		int sum = 0;    //用于记录当前滑动窗口的和
		int res = nums.length + 1;

		while(l < nums.length){
			if(sum < s && r + 1 < nums.length){    //当前窗口和小于s且窗口还可以往右拓展的时候
				r++;
				sum += nums[r];
			}else {
				sum -= nums[l];
				l++;
			}
			//得到了一个新的窗口
			if(sum >= s){
				res = (res > r - l + 1) ? (r - l + 1) : res;
			}
		}

		if(res == nums.length + 1){
			return 0;
		}else {
			return res;
		}
	}
}
