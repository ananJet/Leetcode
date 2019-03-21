public class UniquePathsWithObstacles {

    public int[][] obstacleGrid;
    public int[][] dp;

    public int dg(int x, int y) {
        if (this.dp[x][y] != -1)
            return this.dp[x][y];
        if (this.obstacleGrid[x][y] == 1) {
            this.dp[x][y] = 0;
            return this.dp[x][y];
        }
        int nextX = x + 1;
        int nextY = y + 1;
        if (x == this.dp.length - 1) {
//            if (this.obstacleGrid[x][nextY] == 1)
//                this.dp[x][y] = 0;
            this.dp[x][y] = this.dg(x, nextY);
        }else if (y == this.dp[0].length - 1) {
//            if (this.obstacleGrid[nextX][y] == 1)
//                this.dp[x][y] = 0;
            this.dp[x][y] = this.dg(nextX, y);
        }else {
            this.dp[x][y] = this.dg(nextX, y) + this.dg(x, nextY);
        }
        return this.dp[x][y];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0)
            return 0;
        this.obstacleGrid = obstacleGrid;
        this.dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < this.dp.length; i++) {
            for (int j = 0; j < this.dp[0].length; j++) {
                this.dp[i][j] = -1;
            }
        }
        this.dp[this.dp.length - 1][this.dp[0].length - 1] = this.obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1 ? 0 : 1;
        return this.dg(0, 0);
    }
}
