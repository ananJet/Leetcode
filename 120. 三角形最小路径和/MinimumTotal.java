import java.util.Arrays;
import java.util.List;

public class MinimumTotal {

    public int min;
    public int n;

    public int minimumTotal1(List<List<Integer>> triangle) {
        this.n = triangle.size();
        if (this.n == 0)
            return 0;
        if (this.n == 1)
            return triangle.get(0).get(0);
        this.min = Integer.MAX_VALUE;
        this.dg(triangle.get(0).get(0), triangle, 1, 0);
        return this.min;
    }

    public void dg(int sum, List<List<Integer>> triangle, int layer, int index) {
        List<Integer> l = triangle.get(layer);
        int a = l.get(index);
        int b = l.get(index + 1);
        if (layer == this.n - 1) {
            int temp = Math.min(a, b);
            sum += temp;
            if (sum < this.min)
                this.min = sum;
            return;
        }
        int left = sum + a;
        if (left < this.min) {
            this.dg(left, triangle, layer + 1, index);
        }
        int right = sum + b;
        if (right < this.min) {
            this.dg(right, triangle, layer + 1, index + 1);
        }
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0)
            return 0;
        if (n == 1)
            return triangle.get(0).get(0);
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> last_layer = triangle.get(i - 1);
            List<Integer> layer = triangle.get(i);
            int size = i + 1;
            for (int j = 0; j < size; j++) {
                int temp = layer.get(j);
//                获得当前点与上一层点的和
                int r1 = Integer.MAX_VALUE;
                if (j > 0) {
                    r1 = dp[i - 1][j - 1] + temp;
                }
                int r2 = Integer.MAX_VALUE;
                if (j < size - 1) {
                    r2 = dp[i - 1][j] + temp;
                }
//                System.out.println(r1 + "\t" + r2);
                dp[i][j] = Math.min(r1, r2);
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }

}
