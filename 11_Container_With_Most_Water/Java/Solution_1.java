public class Solution_1 {

	/**
	 *
	 * Date : 2018/11/6
	 *
	 *
	 */
	public int maxArea(int[] height) {
		//使用对撞指针的思想：
		//从边界开始，如果想要让max增加的话，必须让小的一边移动找到更大的height

		if(height == null || height.length == 0){
			return 0;
		}

		int l = 0;
		int r = height.length - 1;

		int max = calArea(height, l, r);
		while(l < r){
			int tempArea = calArea(height, l, r);
			max = (tempArea > max) ? tempArea : max;
			if(height[l] > height[r]){
				r = nextRight(height, r);
			}else {
				l = nextLeft(height, l);
			}
		}

		return max;
	}

	private int nextLeft(int[] height, int l){
		int h = height[l];
		for(int i = l; i < height.length; i++){
			if(height[i] > h){
				return i;
			}
		}

		return height.length;

	}
	private int nextRight(int[] height, int r){
		int h = height[r];
		for(int i = r; i >= 0; i--){
			if(height[i] > h){
				return i;
			}
		}

		return -1;

	}

	private int calArea(int[] height, int i, int j){
		int h = (height[i] > height[j]) ? height[j] : height[i];
		int area = h * ((i > j) ? (i - j) : (j - i));
		return area;
	}

	public static void main(String[] args) {
		Solution_1 solution_1 = new Solution_1();
		int[] a = {1,8,6,2,5,4,8,3,7};
		System.out.println(solution_1.maxArea(a));
	}
}
