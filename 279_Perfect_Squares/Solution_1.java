public class Solution_1 {
//    Runtime: 10 ms, faster than 96.92% of Java online submissions for Perfect Squares.
//    Memory Usage: 34.8 MB, less than 98.94% of Java online submissions for Perfect Squares.
    public int numSquares(int n) {
        assert (n >= 0);

        Queue<Integer> queue = new LinkedList<>();
        int[] leastStep = new int[n + 1];//leastStep[i] 是从n出发到i最短的距离
        int[] visited = new int[n + 1];//visited[i] = 1的话说明1被访问过了;
        queue.offer(n);

        while (true) {
            int num = queue.poll();
            int step = leastStep[num];
            int i = 1;
            while (true) {
                int remain = num - i*i;
                if (remain < 0) {
                    break;
                }
                if (remain == 0) {
                    return step + 1;
                }
                if (visited[remain] == 0) {
                    queue.offer(remain);
                    leastStep[remain] = step + 1;
                    visited[remain] = 1;
                }
                i++;
            }
        }
    }
}
