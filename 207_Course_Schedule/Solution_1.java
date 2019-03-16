public class Solution_1 {

//    Runtime: 5 ms, faster than 93.71% of Java online submissions for Course Schedule.
//    Memory Usage: 45.8 MB, less than 33.56% of Java online submissions for Course Schedule.

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] adjList = new List[numCourses];
        int[] degree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<Integer>();
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

        int finishedCour = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            finishedCour++;
            for (int i = 0; i < adjList[cur].size(); i++) {
                int adjCour = (int)adjList[cur].get(i);
                degree[adjCour]--;
                if (degree[adjCour] == 0) {
                    queue.offer(adjCour);
                }
            }
        }

        return finishedCour == numCourses;
    }
}
