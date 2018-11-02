import java.util.Arrays;

public class Solution_2 {
	public void sortColors(int[] nums){
		//采用三路快排同样的思路
		//用三个指针来标定三种不同的元素

		int zero = 0;
		int one = 0;
		int two = nums.length - 1;

		//其中nums[0...zero - 1]全部为0
		//nums[zero...one - 1]全部为1
		//nums[two + 1...nums.length - 1]全部为2



		//循环终止条件 ： 扫描完整个数组（即碰到）
		while(one != (two + 1)){
			if(nums[one] == 0){
				swap(nums, zero, one);
				zero++;
			}
			if(nums[one] == 2){
				swap(nums, one , two);
				two --;
				continue;
			}

			one++;
		}


	}

	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = {2,0,2,1,1,0};
		Solution_2 solution_2 = new Solution_2();
		solution_2.sortColors(a);
		System.out.println(Arrays.toString(a));
	}
}
