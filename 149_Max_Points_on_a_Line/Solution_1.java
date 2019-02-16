import java.math.BigDecimal;
import java.util.*;

public class Solution_1 {


    public int maxPoints(Point[] points) {
        /**
         * Runtime: 17 ms, faster than 57.14% of Java online submissions for Max Points on a Line.
         * Memory Usage: 37.9 MB, less than 100.00% of Java online submissions for Max Points on a Line.
         */

        if (points.length == 0) {
            return 0;
        }

        int ret = 1;

        //initialization
        List<Map<Double, Integer>> mapList = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> slopeMap = new HashMap<>();
            mapList.add(i, slopeMap);
        }

        //计算从每个点出发的所有的斜率
        for (int start = 0; start < points.length - 1; start++) {
            int repeatNum = 0;
            for (int end = start + 1; end < points.length; end++) {
                if ((points[end].x - points[start].x) == 0) {
                    if (points[end].y == points[start].y) {
                        repeatNum++;
                    } else {
                        addSlope(mapList.get(start), Double.NaN);
                        addSlope(mapList.get(end), Double.NaN);
                    }
                } else {
                    double slope = (points[end].x - points[start].x)/(double) (points[end].y - points[start].y);
                    addSlope(mapList.get(start), slope);
                    addSlope(mapList.get(end), slope);
                }
            }
            if (repeatNum != 0) {
                Map<Double, Integer> map = mapList.get(start);
                Iterator<Double> i = map.keySet().iterator();
                while (i.hasNext()) {
                    Double key = i.next();
                    map.put(key, map.get(key) + repeatNum);
                }

                ret = Integer.max(ret, repeatNum + 1);
            }
        }

        for (int index = 0; index < points.length; index++) {
            Map slopeMap = mapList.get(index);
            Iterator<Integer> i = slopeMap.values().iterator();
            while (i.hasNext()) {
                int slopeNum = i.next();
                if (slopeNum > ret) {
                    ret = slopeNum;
                }
            }
        }

        return ret;
    }

    private void addSlope(Map<Double, Integer> map, double slope) {
        if (!map.containsKey(slope)) {
            map.put(slope, 2);
        } else {
            map.put(slope, map.get(slope) + 1);
        }
    }
    //[[0,0],[94911151,94911150],[94911152,94911151]]
    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        Point[] points = {new Point(0,0), new Point(94911151,94911150), new Point(94911152,94911151)};
        System.out.println(solution_1.maxPoints(points));
    }
}
