public class Solution_2 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int longest = 1;
        int start = 0;

        for (int i = 0; i < s.length(); ++i) {
            int oddLength = expandFromCenter(s, i, i);
            int evenLength = expandFromCenter(s, i, i + 1);
            int longer = Math.max(oddLength, evenLength);
            if (longer > longest) {
                start = i - (longer - 1) / 2;
                longest = longer;
            }

        }

        return s.substring(start, start + longest);


    }

    private int expandFromCenter(String s, int left, int right) {
        int i = left, j = right;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
