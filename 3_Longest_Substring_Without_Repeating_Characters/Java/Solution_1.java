import java.util.HashSet;

public class Solution_1 {
	public int lengthOfLongestSubstring(String s) {

		/**
		 * Date : 2018/11/9
		 * beats : 92.55%
		 */

		if (s == null || s.length() == 0){
			return 0;
		}

		HashSet<Character> currSub = new HashSet<>();
		//使用滑动窗口遍历所有子串
		int l = 0;
		int r = 0;    //r指向下一个待检查元素
		int max = 0;

		while(r < s.length()){
			if(!currSub.contains(s.charAt(r))){
				max = (max > r - l + 1) ? max : (r - l + 1);
				currSub.add(s.charAt(r));
				r++;
			}else {
				while(currSub.contains(s.charAt(r))){
					currSub.remove(s.charAt(l));
					l++;
				}
			}
		}

		return max;
	}


	public static void main(String[] args) {
		String a = "pwwkew";
		Solution_1 solution_1 = new Solution_1();
		System.out.println(solution_1.lengthOfLongestSubstring(a));
	}
}
