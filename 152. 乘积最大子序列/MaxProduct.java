public class MaxProduct {

    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int res = Integer.MIN_VALUE;

        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = this.getMax(nums, begin, i - 1);
                begin = i + 1;
                if (temp > res) {
                    res = temp;
                }
            }
        }
        res = Math.max(this.getMax(nums, begin, nums.length - 1), res);
        return Math.max(res, 0);
    }

    public int getMax(int[] nums, int begin, int end) {
//        System.out.println(begin + "\t" + end);
        if (begin > end)
            return -1;
        if (begin == end)
            return nums[begin];
//        获得负数的个数
        int n_negative = 0;
//        所有数的乘积
        int product = 1;
        for (int i = begin; i <= end; i++) {
            product *= nums[i];
            if (nums[i] < 0)
                n_negative++;
        }

        if ((n_negative & 1) == 0) {
            return product;
        }else {
            int product_left = product;
            for (int i = end; i >= begin; i--) {
                product_left /= nums[i];
                if (nums[i] < 0) {
                    break;
                }
            }
            int product_right = product;
            for (int i = begin; i <= end; i++) {
                product_right /= nums[i];
                if (nums[i] < 0) {
                    break;
                }
            }
            return Math.max(product_left, product_right);
        }
    }

    public static void main(String[] args) {
        new MaxProduct().maxProduct(new int[]{-2,0,-1});
    }
}
