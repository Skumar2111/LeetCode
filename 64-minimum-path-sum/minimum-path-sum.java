class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

           for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return pathSum(grid, dp, 0, 0);
    }

    public int pathSum(int[][] grid, int[][] dp, int i, int j) {

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (i + 1 < grid.length) {
            down = pathSum(grid, dp, i + 1, j);
        }

        if (j + 1 < grid[0].length) {
            right = pathSum(grid, dp, i, j + 1);
        }

        dp[i][j] = grid[i][j] + Math.min(down, right);

        return dp[i][j];
    }
}