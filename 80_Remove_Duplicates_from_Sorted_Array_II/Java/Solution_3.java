import java.util.Arrays;

public class Solution_3 {


	public int removeDuplicates(int[] nums){

		/**
		 * Date : 2018/11/2
		 *
		 * ps : 发现跟100%的选手简直一摸一样，但是这次却是
		 * beats 33.12%
		 *
		 *
		 */


		//思想：最多重复两次意味着判断当前元素是否要装填的时候就是判断该数的重复次数，当满足以下条件的时候不可装填：
		//已装填的数组尾部已出现过两次相同元素

		//即需要判断当前元素和倒数第二个元素是否相同。
		if(nums == null || nums.length == 0){
			return 0;
		}

		int k = 0;

		for(int num:nums){
			if(k < 2 || num > nums[k - 2]){
				nums[k] = num;
				k++;
			}
		}

		return k;
	}

	public static void main(String[] args) {
		int[] a = {1,1,1,2,2,3};
		Solution_3 solution_3 = new Solution_3();


		System.out.println(solution_3.removeDuplicates(a));
		System.out.println(Arrays.toString(a));
	}
}
