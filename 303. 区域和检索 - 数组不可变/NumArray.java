class NumArray {

    public int[] nums;
    public int[] dp;

    public NumArray(int[] nums) {
        if (nums.length == 0)
            return;
        this.nums = nums;
//        一维数组保存累加和
        this.dp = new int[this.nums.length];
        this.dp[0] = nums[0];
        for (int i = 1; i < this.nums.length; i++) {
            this.dp[i] = this.nums[i] + this.dp[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? this.dp[j] : this.dp[j] - this.dp[i - 1];
    }

    public static void main(String[] args) {
        new NumArray(new int[]{});
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */