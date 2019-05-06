public class NumIslands {

    public boolean[][] passed;
    public int res;

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        this.passed = new boolean[grid.length][grid[0].length];
        this.res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((!this.passed[i][j]) && grid[i][j] == '1') {
                    this.res++;
                    this.dg(grid, i, j);
                }
            }
        }
        return this.res;
    }

    public void dg(char[][] grid, int x, int y) {
//        上下左右四个方向搜索
        System.out.println(x + "\t" + y);
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            if (!this.passed[x][y]) {
                if (grid[x][y] == '1') {
                    this.passed[x][y] = true;
                    this.dg(grid, x - 1, y);
                    this.dg(grid, x + 1, y);
                    this.dg(grid, x, y - 1);
                    this.dg(grid, x, y + 1);
                }
            }
        }
    }
}
