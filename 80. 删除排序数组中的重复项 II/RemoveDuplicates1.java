import java.util.Arrays;

public class RemoveDuplicates1 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
//        上一个数组元素标志
        int last = nums[0];
//        上一个数组元素出现次数
        int time = 1;
//        重复元素总次数，即删除元素的总个数
        int delete = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                time++;
            }else {
                last = nums[i];
                time = 1;
            }
            if (time > 2) {
                delete++;
            }
//            replace
            if (delete > 0) {
                int poi = i - delete;
                nums[poi] = nums[i];
            }
        }
        return nums.length - delete;
    }

    public int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3};
        System.out.println(new RemoveDuplicates1().removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }
}
