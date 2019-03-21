public class Rob1 {

//    自底向上动态规划
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
//        不偷第一个
        int res1 = -1;
        if (nums.length == 2)
            res1 = nums[1];
        else if (nums.length == 3)
            res1 = Math.max(nums[1], nums[2]);
        else {
            dp = new int[nums.length];
            dp[1] = nums[1];
            dp[2] = Math.max(nums[1], nums[2]);
            for (int i = 3; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            res1 = dp[nums.length - 1];
        }
//        偷第一个
        int res2 = -1;
        if (nums.length <= 3)
            res2 = 0;
        else if (nums.length == 4)
            res2 = nums[2];
        else if (nums.length == 5)
            res2 = Math.max(nums[2], nums[3]);
        else {
            dp = new int[nums.length];
            dp[2] = nums[2];
            dp[3] = Math.max(nums[2], nums[3]);
            for (int i = 4; i < nums.length - 1; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            res2 = dp[nums.length - 2];
        }
        return Math.max(res1, res2 + nums[0]);
    }

    public static void main(String[] args) {
        System.out.println(new Rob1().rob(new int[]{1, 2, 3, 1}));
    }

}
