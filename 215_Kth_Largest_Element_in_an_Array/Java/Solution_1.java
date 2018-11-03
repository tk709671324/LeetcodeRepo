public class Solution_1 {
	public int findKthLargest(int[] nums, int k) {
		/**
		 * Date : 2018/11/2
		 *
		 * beats 97.50%
		 *
		 * ps : 因为最开始的时候看错题了以为是求第k小的元素，后来发现了就又不想重新写快排就导致传递参数的时候有点别扭，但不影响整体思路和效率。
		 */
		//采用快排的思路：寻找某一个元素的位置
		int index = findK(nums, 0, nums.length - 1, nums.length - k);
		return nums[index];
	}

	private int partition(int[] nums, int l, int r){
		//每次partition会将传入nums[l] 放到对应的位置并返回对应的索引值
		//并且将l到r段中nums[l]对应位置的左边全为比它小的元素，右边全为比它大的元素

		if(l == r){
			return l;
		}


		swap( nums, l , (int)(Math.random()*(r-l+1))+l );


		int p = nums[l];
		int j = l; //j指向的是所有比p小的最后一个元素
		for(int i = l + 1; i <= r;i++){
			if(nums[i] < p){
				j++;
				swap(nums, i, j);
			}
		}

		swap(nums, l, j);

		return j;
	}

	private int findK(int[] nums, int l , int r, int k){
		//返回从小到大的第k小的元素的索引值

		int p = partition(nums, l , r);
		if(p == k){
			return k;
		}
		if(p < k){
			return findK(nums, p + 1, r, k);
		}else {
			return findK(nums, l, p - 1, k);
		}

	}

	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		Solution_1 solution_1 = new Solution_1();
		int[] a = {3,2,1,5,6,4};

		System.out.println(solution_1.findKthLargest(a, 2));
	}
}
