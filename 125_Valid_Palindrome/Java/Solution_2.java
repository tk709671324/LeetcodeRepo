public class Solution_2 {

	/**
	 *
	 * Date : 2018/11/5
	 *
	 * beats 62.15%
	 * time complexity : O(n)
	 * space complexity : O(1)
	 */
	public boolean isPalindrome(String s) {

		//在本题中全部转化为小写就可以达成无视大小写的功能
		s = s.toLowerCase();
		int l = 0;
		int r = s.length() - 1;
		while(l < r){
			while((!Character.isLetter(s.charAt(l))) && (!Character.isDigit(s.charAt(l)))){
				if(l < r){
					l++;
				}
				else{
					break;
				}
			}
			while((!Character.isLetter(s.charAt(r))) && (!Character.isDigit(s.charAt(r)))){
				if(l < r){
					r--;
				}
				else{
					break;
				}
			}
			if(l < r){
				if(s.charAt(l) != s.charAt(r)){
					return false;
				}else {
					l++;
					r--;
				}
			}
		}

		return true;
	}

}
