public class ThirdMax {
    public int thirdMax(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
//        如果相同就不管
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if (nums[i] > max2 && nums[i] != max1) {
                max3 = max2;
                max2 = nums[i];
            }else if (nums[i] > max3 && nums[i] != max1 && nums[i] != max2) {
                max3 = nums[i];
            }
//            System.out.println(max1 + "\t" + max2 + "\t" + max3);
        }
        return (int) (max3 == Long.MIN_VALUE ? max1 : max3);
    }

    public static void main(String[] args) {
        System.out.println(new ThirdMax().thirdMax(new int[]{2,2,3, 1}));
    }
}
