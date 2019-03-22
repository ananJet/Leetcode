import java.util.Arrays;

public class MinPathSum {

    public int[][] dp;
    public int[][] grid;

    public int dg(int x, int y) {
        if (this.dp[x][y] != Integer.MIN_VALUE)
            return this.dp[x][y];
        this.dp[x][y] = Math.min(this.grid[x][y] + this.dg(x + 1, y), this.grid[x][y] + this.dg(x, y + 1));
        return this.dp[x][y];
    }

    public int minPathSum(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        if (row == 1) {
            for (int i = 0; i < col; i++) {
                res += grid[0][i];
            }
            return res;
        }
        if (col == 1) {
            for (int i = 0; i < row; i++) {
                res += grid[i][col];
            }
            return res;
        }
//        Ìî³ä±ß½çÌõ¼þdp
        this.grid = grid;
        this.dp = new int[row][col];
        for (int i = 0; i < this.dp.length; i++) {
            for (int j = 0; j < this.dp[0].length; j++) {
                this.dp[i][j] = Integer.MIN_VALUE;
            }
        }
        int temp = 0;
        int row_temp = row - 1;
        for (int i = col - 1; i >= 0; i--) {
            temp += grid[row_temp][i];
            this.dp[row_temp][i] = temp;
        }
        temp = 0;
        int col_temp = col - 1;
        for (int i = row - 1; i >= 0; i--) {
            temp += grid[i][col_temp];
            this.dp[i][col_temp] = temp;
        }
//        System.out.println(row_temp);
        return this.dg(0, 0);
    }

    public static void main(String[] args) {
        System.out.println(new MinPathSum().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
