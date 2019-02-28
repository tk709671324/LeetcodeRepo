public class Solution_1 {

//    Runtime: 7 ms, faster than 100.00% of Java online submissions for Pow(x, n).
//    Memory Usage: 38 MB, less than 21.40% of Java online submissions for Pow(x, n).

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            if (n > 0) {
                return half * half * x;
            } else {
                return half * half / x;
            }
        }
    }
}
