public class Solution_3 {
    public int numIslands(char[][] grid) {
//        Runtime: 3 ms, faster than 99.99% of Java online submissions for Number of Islands.
//        Memory Usage: 41.4 MB, less than 5.02% of Java online submissions for Number of Islands.

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
                    dfs(grid, i, j);
                }
            }
        }

        return islandsNum;
    }

    private void dfs(char[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;

        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
