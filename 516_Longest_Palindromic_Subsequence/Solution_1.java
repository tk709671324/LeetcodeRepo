public class Solution_1 {
    public int longestPalindromeSubseq(String s) {
//        Runtime: 20 ms, faster than 94.98% of Java online submissions for Longest Palindromic Subsequence.
//                Memory Usage: 50.4 MB, less than 15.35% of Java online submissions for Longest Palindromic Subsequence.


        if (s.length() == 0 || s == null) {
            return 0;
        }

        int n = s.length();
        int[][] LongestSubseq = new int[n][n];
        for (int i = 0; i < n; i++) {
            LongestSubseq[i][i] = 1;
        }
        return dp(LongestSubseq, 0, n - 1, s);
    }

    private int dp(int[][] LongestSeq, int l, int r, String src) {
        if (l > r || LongestSeq[l][r] != 0) {
            //l > r表示已经检索完 [l ... r]
            //LongestSeq[l][r] != 0 表示已经计算出了最长
            return LongestSeq[l][r];
        }
        if (src.charAt(l) == src.charAt(r)) {
            return dp(LongestSeq, l + 1, r - 1, src) + 2;
        } else {
            LongestSeq[l][r] = Math.max(dp(LongestSeq, l + 1, r, src), dp(LongestSeq, l, r - 1, src));
        }

        return LongestSeq[l][r];
    }
}
