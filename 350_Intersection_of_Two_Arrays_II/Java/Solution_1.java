import java.util.ArrayList;
import java.util.HashMap;

public class Solution_1 {

    /**
     * time complexity : O(n)
     * <p>
     * beats : 81.30%%
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        HashMap<Integer, Integer> record = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int aNums1 : nums1) {
            if (!record.containsKey(aNums1)) {
                record.put(aNums1, 1);
            } else {
                record.put(aNums1, record.get(aNums1) + 1);
            }
        }

        for (int aNums2 : nums2) {
            if (record.containsKey(aNums2) && record.get(aNums2) > 0) {
                record.replace(aNums2, record.get(aNums2) - 1);
                arrayList.add(aNums2);
            }
        }

        int[] res = new int[arrayList.size()];
        int index = 0;

        for (Integer num : arrayList) {
            res[index++] = num;
        }

        return res;


    }

}
