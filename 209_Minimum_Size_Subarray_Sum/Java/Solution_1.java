public class Solution_1 {

	/**
	 *
	 * Date : 2018/11/6
	 *
	 * beats : 9.35%
	 *
	 * time complexity : O(n^2)
	 *
	 */
	public int minSubArrayLen(int s, int[] nums) {

		if(nums == null || nums.length == 0){
			return 0;
		}



		int minLength = nums.length + 1;

		for(int start = 0; start < nums.length; start++){
			int tempSum = 0;
			int end = start;
			int length = 0;
			for(;end < nums.length; end ++){
				tempSum += nums[end];
				if(tempSum >= s){
					break;
				}
			}
			if(tempSum < s){ //如果tempSum < s， 则说明上面for循环查找完最长subarray都没有满足要求
				continue;
			}else {
				length = end - start + 1;
			}


			minLength = (length < minLength) ? length : minLength;
		}

		return (minLength <= nums.length) ? minLength : 0;

	}

	public static void main(String[] args) {
		Solution_1 solution_1 = new Solution_1();
		int[] a = {1,1,1};
		System.out.println(solution_1.minSubArrayLen(7, a));
	}
}
