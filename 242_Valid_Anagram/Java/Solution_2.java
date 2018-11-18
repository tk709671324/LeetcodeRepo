public class Solution_2 {

    /*
    Date : 2017/11/17
    Time Complexity : O(n)
    Space Complexity : O(1)
    beats : 96.87%
     */
    public boolean isAnagram(String s, String t){
        //思路和solution_1一致， 只是用了更简便快速的方法

        //在此处检查长度所使用的时间占比太大
//        if (s.length() != t.length()) {
//            return false;
//        }

        int[] alphabet = new int[26];
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        for (char c : charS){
            int index = c - 'a';
            alphabet[index]++;
        }

        for (char c : charT) {
            int index = c - 'a';
            if (alphabet[index] == 0) {
                return false;
            }else {
                alphabet[index]--;
            }
        }

        for (int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
