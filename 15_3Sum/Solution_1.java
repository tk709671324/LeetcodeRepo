
import java.util.*;

public class Solution_1 {
    public List<List<Integer>> threeSum(int[] nums) {

        /*
        Date : 2018/11/29
        Time : O(n^2)
        beats : 23.81%
         */

        HashMap<Integer, Integer> counter = new HashMap<>();

        List<List<Integer>> res = new ArrayList<>();

        for (int n : nums) {
            if (counter.containsKey(n)) {
                counter.put(n, counter.get(n) + 1);
            }else {
                counter.put(n, 1);
            }
        }

        if (counter.containsKey(0) && counter.get(0) >= 3) {
            ArrayList<Integer> list = new ArrayList();
            list.add(0);
            list.add(0);
            list.add(0);
            res.add(list);
        }

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        Iterator<Integer> iterator = set.iterator();
        int[] new_nums = new int[set.size()];
        for (int i = 0; iterator.hasNext(); i++) {
            new_nums[i] = iterator.next();
        }

        Arrays.sort(new_nums);

        for (int i = 0; i < new_nums.length - 1; i++) {
            for (int j = i + 1; j < new_nums.length; j ++) {
                if (new_nums[i] * 2 + new_nums[j] == 0 && counter.get(new_nums[i]) >= 2) {
                    ArrayList<Integer> list = new ArrayList();
                    list.add(new_nums[i]);
                    list.add(new_nums[i]);
                    list.add(new_nums[j]);
                    res.add(list);
                }

                if (new_nums[i] + new_nums[j] * 2 == 0 && counter.get(new_nums[j]) >= 2) {
                    ArrayList<Integer> list = new ArrayList();
                    list.add(new_nums[i]);
                    list.add(new_nums[j]);
                    list.add(new_nums[j]);
                    res.add(list);
                }

                int c = 0 - new_nums[i] - new_nums[j];

                if (c > new_nums[j] && counter.containsKey(c)) {
                    ArrayList<Integer> list = new ArrayList();
                    list.add(new_nums[i]);
                    list.add(new_nums[j]);
                    list.add(c);
                    res.add(list);
                }
            }
        }

        return res;
    }
}
