public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)
            return 0;
        if (nums.length == 3)
            return nums[0] + nums[1] + nums[2];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }

        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            for (int l = i + 1; l < nums.length; l++) {
                int last = nums[i] + nums[l] + nums[nums.length - 1];
                for (int r = nums.length - 1; r > l; r--) {
                    int temp = nums[i] + nums[l] + nums[r];
                    if (Math.abs(temp - target) > Math.abs(last - target)) {
                        break;
                    }else {
                        if (Math.abs(temp - target) < Math.abs(res - target)) {
                            res = temp;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{1,1,1,1}, 1));
    }
}
