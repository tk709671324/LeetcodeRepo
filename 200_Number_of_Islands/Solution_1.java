import sun.plugin.dom.core.CoreConstants;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1 {

    // TLE
    // bfs的方法，如果优化结构则能够通过测试
    //见方法二
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int islandsNum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    islandsNum++;
                    bfs(grid, i, j);
                }
            }
        }

        return islandsNum;
    }

    private void bfs(char[][] grid, int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x * grid[0].length + y);

        int[] directionX = {0, 0, 1, -1};
        int[] directionY = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int row = cur / grid[0].length;
            int col = cur % grid[0].length;
            grid[row][col] = '0';

            for (int i = 0; i < 4; i++) {
                int adj = (row + directionX[i]) * grid[0].length + (col + directionY[i]);
                if (!inBound(grid, row + directionX[i], col + directionY[i])) {
                    continue;
                }

                if (grid[row + directionX[i]][col + directionY[i]] == '1') {
                    queue.offer(adj);
                }
            }
        }
    }

    private boolean inBound(char[][] grid, int row, int col) {

        return row >= 0 &&
                row < grid.length &&
                col >= 0 &&
                col < grid[0].length;
    }

}
