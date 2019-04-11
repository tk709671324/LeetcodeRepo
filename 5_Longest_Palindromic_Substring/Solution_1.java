public class Solution_1 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            isPalindrome[i][i] = true;
        }

        int start = 0;
        int longestLength = 1;

        for (int i = 0; i < n - 1; ++i) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            if (isPalindrome[i][i + 1]) {
                start = i;
                longestLength = 2;
            }
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 2; j < n; ++j) {
                isPalindrome[i][j] = (isPalindrome[i + 1][j - 1] &&
                        s.charAt(i) == s.charAt(j));
                if (isPalindrome[i][j] && j - i + 1 > longestLength) {
                    longestLength = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + longestLength);
    }
}
