public class Solution_2 {

//    Runtime: 19 ms, faster than 85.26% of Java online submissions for Perfect Squares.
//    Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for Perfect Squares.
    public int numSquares(int n) {
        assert (n >= 0);

        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                j++;
            }
            dp[i] = min;
        }

        return dp[n];
    }
}
