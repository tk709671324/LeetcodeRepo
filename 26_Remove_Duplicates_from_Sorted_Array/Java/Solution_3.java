import java.util.Arrays;

public class Solution_3 {
	/**
	 *
	 *  Date : 2018/11/1
	 *
	 *  beats:90.90%
	 *
	 *  ps其实是solution2的一种更易读的写法
	 */
	public int removeDuplicates(int[] nums){
		//采用双指针
		//其中一个指针(k)用于指向不重复段的最末尾元素
		//另外一个指针(index)用于查找下一个不重复元素

		int k = 1;
		int index = nextDifferentElement(nums, 1);
		while(index < nums.length){
			nums[k] = nums[index];
			k++;
			index = nextDifferentElement(nums, index + 1);  //index 赋值为的下一个不同元素(与nums[index]不同)的索引
		}

		return k ;
	}

	private int nextDifferentElement(int[] arr, int i){
		for (; i < arr.length; i++){
			if(arr[i - 1] != arr[i]){
				break;
			}
		}

		return i;
	}

	public static void main(String[] args) {
		int a[] = {1,2};

		Solution_3 solution_3 = new Solution_3();

		System.out.println(solution_3.removeDuplicates(a));
		System.out.println(Arrays.toString(a));
	}
}
