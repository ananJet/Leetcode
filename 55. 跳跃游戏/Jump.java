import java.util.Arrays;

public class Jump {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int[] dp = new int[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
//            System.out.println("---------------------");
            if (nums.length - i - 1 <= nums[i])
                dp[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                int end = i + nums[i] + 1;
                int begin = i + 1;
                for (int j = end - 1; j >= begin; j--) {
//                    System.out.println(j);
                    if (dp[j] != 0) {
                        int temp = 1 + dp[j];
                        if (temp < min) {
                            min = temp;
                        }
                    }
                    if (min == 2)
                        break;
                }
                dp[i] = min == Integer.MAX_VALUE ? 0 : min;
            }
//            System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new Jump().jump(new int[]{}));
    }
}
