import java.util.Arrays;

public class Solution_1 {

	/**
	 *
	 * Data : 2018/11/2
	 *
	 * beats 33.12%
	 */
	public int removeDuplicates(int[] nums) {


		int k = 0;
		int i = 0;

		for(; i < nums.length; i = nextDifferentElement(nums, i + 1)){
			//Initialization : 每一次循环开始的时候i指向下一个与nums[k - 1]不同的元素，nums[0...k - 1]满足题意
			//循环每一次都让i 变成下一个不一样元素的index
			//每次需要检查i和i + 1是否相等，相等的话就往k处放入两个元素，不相等的话放入一个元素；
			nums[k] = nums[i];
			k++;

			//判断i+1 是否重复
			//前提是需要判断i+1是否有意义
			if(i + 1 < nums.length && nums[i + 1] == nums[i]){
				nums[k] = nums[i + 1];
				k++;
				i++;
			}


		}

		return k;
	}

	private int nextDifferentElement(int[] nums, int i){ // 返回从arr[i] 到 arr[length - 1]中第一个与arr[i - 1]不同元素的索引值
		for (; i < nums.length; i++){
			if(nums[i - 1] != nums[i]){
				break;
			}
		}

		return i;
	}


	public static void main(String[] args) {
		int[] a = {1,1,1,2,2,3};

		Solution_1 solution_1 = new Solution_1();

		System.out.println(solution_1.removeDuplicates(a));
		System.out.println(Arrays.toString(a));
	}

}
