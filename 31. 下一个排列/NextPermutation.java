import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
//        System.out.println(Arrays.toString(nums));
        int index = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                int min = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] < nums[min] && nums[j] > nums[i - 1])
                        min = j;
                }
                int temp = nums[min];
                nums[min] = nums[i - 1];
                nums[i - 1] = temp;
                index = i;
                break;
            }
        }
        for (int i = index; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int mini = -1;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    mini = j;
                }
            }
            int temp = nums[mini];
            nums[mini] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 2, 0, 2, 3, 2, 0};
        new NextPermutation().nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}
