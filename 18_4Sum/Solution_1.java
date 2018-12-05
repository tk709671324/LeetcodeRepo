import java.util.*;

public class Solution_1 {
    /*
    Date : 2018/11/29
    beats : 6.09%
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        HashMap<Integer, Integer> remvDup = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            remvDup.put(nums[i], i);
        }

        Iterator<Integer> integerIterator = remvDup.keySet().iterator();
        while (integerIterator.hasNext()) {
            int i = integerIterator.next();
            int index = remvDup.get(i);
            int[] arr = remove(nums, index);
            Union(arr, i, target - i, set);
        }


        List<List<Integer>> res = new LinkedList<>();
        Iterator<List<Integer>> i = set.iterator();
        while (i.hasNext()) {
            res.add(i.next());
        }

        return res;
    }


    private void Union(int[] nums, int source, int target, Set<List<Integer>> set) {

        //nums 为有序的

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int l = i + 1, r = nums.length - 1, sum = target - nums[i];

                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r], source);
                        Collections.sort(list);
                        set.add(list);

                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }

                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
    }

    private int[] remove(int[] nums, int i) {
        int[] tmp = new int[nums.length - 1];
        for (int j = 0; j < tmp.length; j++) {
            if (j < i) {
                tmp[j] = nums[j];
            } else {
                tmp[j] = nums[j + 1];
            }
        }

        return tmp;
    }

    public static void main(String[] args) {
        HashSet<List<Integer>> set = new HashSet<>();
        Solution_1 solution_1 = new Solution_1();
        int[] i = {0, 0, 0, 0, 0, 0};
        List<List<Integer>> list = solution_1.fourSum(i, 0);

        System.out.println("done");
    }


}
