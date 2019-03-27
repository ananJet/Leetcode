import java.util.Arrays;
import java.util.HashSet;

public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        if (n <= 0)
            return 0;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int i = 1;
        while (i < n) {

            int min = Math.min(Math.min(dp[index2] * 2, dp[index3] * 3), dp[index5] * 5);

            dp[i] = min;
            if (dp[index2] * 2 == min)
                index2++;
            if (dp[index3] * 3 == min)
                index3++;
            if (dp[index5] * 5 == min)
                index5++;

            i++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {

        System.out.println(new NthUglyNumber().nthUglyNumber(10));
    }
}
