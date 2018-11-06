import java.util.Arrays;

public class Solution_2 {
	public int[] twoSum(int[] numbers, int target){

		/**
		 * Date : 2018/11/5
		 *
		 *
		 * beats : 32.84%
		 * time complexity : O(nlogn)
		 * space complexity : O(1）
		 */
		//对于有序数组，很容易想到的就是二分查找
		for (int i = 0; i < numbers.length; i++){
			int partner = target - numbers[i];
			int j = bs(numbers, i + 1, numbers.length - 1, partner);
			if(j != -1){
				return new int[] {i + 1, j + 1};
			}
		}

		return new int[] {0, 0};
	}



	private int bs(int[] numbers, int l, int r, int partner){
		if(l > r){
			return -1;
		}
		if(l == r){
			if(numbers[l] == partner){
				return l;
			}else {
				return -1;
			}
		}

		int mid = l + (r - l) / 2;

		if(numbers[mid] == partner){
			return mid;
		}
		if(numbers[mid] > partner){
			return bs(numbers, l, mid - 1, partner);
		}else {
			return bs(numbers, mid + 1, r, partner);
		}
	}

	public static void main(String[] args) {

		int[] a = {2,7,11,15};

		Solution_2 solution_2 = new Solution_2();

		int[] res = solution_2.twoSum(a, 9);
		System.out.println(Arrays.toString(res));
	}
}

