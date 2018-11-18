import java.util.HashSet;

public class Solution_1 {
    /*
    Date 2018/11/18
    Time complexity : O(n)
    Space complexity : O(n)
    beats : 78.99%
     */
    public boolean isHappy(int n) {

        int sum = n;
        HashSet<Integer> set = new HashSet<>();

        while (!set.contains(sum)) {
            set.add(sum);
            sum = getSum(sum);
            if (sum == 1) {
                return true;
            }
        }

        return false;

    }

    private int getSum(int n) {
        int sum = 0;
        int digit;
        while (n > 0) {
            digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }




}
