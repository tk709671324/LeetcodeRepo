public class Solution_1 {
    public int firstBadVersion(int n) {

//        Runtime: 10 ms, faster than 99.97% of Java online submissions for First Bad Version.
//        Memory Usage: 34.6 MB, less than 5.29% of Java online submissions for First Bad Version.
        if (isBadVersion(1)) {
            return 1;
        }

        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return end;
    }
}
