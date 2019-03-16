public class Solution_1 {
//    Runtime: 5 ms, faster than 97.02% of Java online submissions for Course Schedule II.
//    Memory Usage: 46.4 MB, less than 24.55% of Java online submissions for Course Schedule II.
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new List[numCourses];
        int[] degree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            adjList[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> res = new ArrayList();
        while (!queue.isEmpty()) {
            int curCour = queue.poll();
            res.add(curCour);

            for (int i = 0; i < adjList[curCour].size(); i++) {
                int adj = adjList[curCour].get(i);
                degree[adj]--;
                if(degree[adj] == 0) {
                    queue.offer(adj);
                }
            }
        }

        if (res.size() == numCourses) {
            int[] ret = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ret[i] = (int)res.get(i);
            }
            return ret;
        } else {
            return new int[0];
        }
    }
}
