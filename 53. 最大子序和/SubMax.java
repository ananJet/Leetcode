public class SubMax {
    public int subMax(int[] nums,int left, int right) {
//        如果子序列只有一个值
        if (left == right) {
            return nums[left];
//            if (nums[left] > 0)
//                return nums[left];
//            else
//                return 0;
        }
        int mid = (left + right) / 2;
        int leftSum = this.subMax(nums, left, mid);
        int rightSum = this.subMax(nums, mid + 1, right);

//        System.out.println(leftSum + " " + rightSum);

//        从中间到左的最大值，从中间到右的最大值
        int leftNow = 0;
        int leftMax = -100000000;
        for (int i = mid; i >= left; i--) {
            leftNow += nums[i];
            if (leftNow > leftMax)
                leftMax = leftNow;
        }

        int rightNow = 0;
        int rightMax = -100000000;
        for (int i = mid + 1; i <= right; i++) {
            rightNow += nums[i];
            if (rightNow > rightMax)
                rightMax = rightNow;
        }
        int max = 0;
        if (leftSum > rightSum) {
            max = leftSum;
        }else {
            max = rightSum;
        }
        if (leftMax + rightMax > max) {
            max = leftMax + rightMax;
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return this.subMax(nums, 0, nums.length - 1);
    }
}
