import java.util.HashSet;
import java.util.Iterator;

public class Solution_1 {

    /**
     *
     * Date : 2018/11/17
     *
     * Time complexity : O(n)
     * Space complexity : O(n)
     *
     * beats : 98.61%
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        HashSet<Integer> record = new HashSet<>();
        HashSet<Integer> resRecord = new HashSet<>();


        for (int num : nums1) {
            record.add(num);
        }

        for (int num : nums2) {
            if (record.contains(num)) {
                resRecord.add(num);
            }
        }

        Iterator<Integer> resIterator = resRecord.iterator();
        int[] res = new int[resRecord.size()];
        int index = 0;
        while (resIterator.hasNext()) {
            res[index++] = resIterator.next();
        }

        return res;

    }
}
