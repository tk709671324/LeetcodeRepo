import java.util.Arrays;

public class Solution_2 {

	/**
	 *
	 * Date : 2018/11/2
	 *
	 * beats 33.12%
	 *
	 *
	 */
	public int removeDuplicates(int[] nums){

		int i = 0;
		int k = 0;


		while(i < nums.length){
			//Initialization : 每一次循环开始的时候i指向下一个与nums[k - 1]不同的元素，nums[0...k - 1]满足题意
			//i 指向准备填装的元素
			//问题的关键在于每次要填装的元素是否重复，重复了几次

			int next = nextDifferentElement(nums, i);
			int len = Integer.min(next - i, 2);
			for(int j = 0; j < len; j++){
				nums[k + j] = nums[i];
			}
			k += len;
			i = next;
		}


		return k;

	}

	private int nextDifferentElement(int[] nums, int i){
		//返回从的一个与nums[i]不同的index
		//如果不存在则返回length
		for(int index = i; index < nums.length; index++){
			if(nums[index] != nums[i]){
				return index;
			}
		}

		return nums.length;
	}

	public static void main(String[] args) {

		int[] a = {1,1,1,2,2,3};

		Solution_2 solution_2 = new Solution_2();
		System.out.println(solution_2.removeDuplicates(a));
		System.out.println(Arrays.toString(a));

	}
}
