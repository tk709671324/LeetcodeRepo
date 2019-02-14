import java.util.*;

public class Solution_1 {

    /**
     *
     * Runtime: 178 ms, faster than 27.24% of Java online submissions for Number of Boomerangs.
     * Memory Usage: 86.2 MB, less than 100.00% of Java online submissions for Number of Boomerangs.
     */
    public int numberOfBoomerangs(int[][] points) {

        int ret = 0;
        List<HashMap<Double, Integer>> mapList = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> disMap = new HashMap<>();
            disMap.put(0.0, 1);
            mapList.add(i, disMap);
        }
        for (int a = 0; a < points.length - 1; a++) {
            for (int b = a + 1; b < points.length; b++) {
                double dis = calDistance(points[a], points[b]);
                HashMap mapA = mapList.get(a);
                HashMap mapB = mapList.get(b);
                if (mapA.containsKey(dis)) {
                    mapA.put(dis, (int)mapA.get(dis) + 1);
                } else {
                    mapA.put(dis, 1);
                }

                if (mapB.containsKey(dis)) {
                    mapB.put(dis, (int) mapB.get(dis) + 1);
                } else {
                    mapB.put(dis, 1);
                }
            }
        }

        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> disMap = mapList.get(i);
            Iterator<Integer> iterator = disMap.values().iterator();
            while (iterator.hasNext()) {
                int nums = iterator.next();
                if (nums != 1) {
                    ret += (nums * (nums - 1));
                }
            }
        }
        return ret;
    }

    private double calDistance(int[] a, int[] b) {
        double dis = Math.sqrt((Math.pow((a[0] - b[0]), 2)) + (Math.pow((a[1] - b[1]), 2)));
        return dis;
    }

    public static void main(String[] args) {
//        int[] a = {0, 0}, b = {-3, 4};
//        Solution_1 solution_1 = new Solution_1();
//        double dis = solution_1.calDistance(a, b);
//        System.out.println(dis);
        Solution_1 solution_1 = new Solution_1();
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(solution_1.numberOfBoomerangs(points));
    }
}
