public class Solution_2 {

    // Your submission beats 91.80% Submissions!

    public int strStr(String source, String target) {
        // Write your code here
        if (source == null || target == null) {
            return -1;
        }

        if (target.length() == 0) {
            return 0;
        }

        if (target.length() > source.length()) {
            return -1;
        }

        int ret = -1;
        int i = 0, j = 0;
        for (; i < source.length() && j < target.length(); i++) {
            if (source.charAt(i) == target.charAt(j)) {
                ret = i - j;
                j++;
            } else {
                if (j != 0) {
                    i--;
                }
                j = 0;
                ret = -1;
            }
        }

        if (j != target.length()) {
            ret = -1;
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution_2 solution_2 = new Solution_2();
        System.out.println(solution_2.strStr("tartarget", "target"));
    }
}
