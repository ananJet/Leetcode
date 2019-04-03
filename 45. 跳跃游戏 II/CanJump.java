import java.util.Arrays;

public class CanJump {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = dp.length - 2; i >= 0; i--) {
            int steps = nums[i];
//            System.out.println(steps);
            boolean flag = false;
            for (int j = 1; j <= steps; j++) {
                if (i + j < nums.length) {
                    if (dp[i + j])
                        flag = true;
                }
            }
            dp[i] = flag;
            System.out.println(Arrays.toString(dp));
        }
//        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{2,0}));
    }
}
