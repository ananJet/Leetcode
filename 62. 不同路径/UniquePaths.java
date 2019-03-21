import java.util.Arrays;

public class UniquePaths {

    public int[][] dp;

    public int dg(int x, int y) {
        if (this.dp[x][y] != 0)
            return this.dp[x][y];
        this.dp[x][y] = this.dg(x + 1, y) + this.dg(x, y + 1);
        return this.dp[x][y];
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        this.dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            this.dp[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            this.dp[m - 1][i] = 1;
        }
        return this.dg(0 ,0);
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(7, 3));
    }
}
