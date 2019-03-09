import java.util.Arrays;

public class Sort {

//    冒泡排序
    public void bubble(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 1; j < nums.length - i; j++) {
//                ����
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;
        }
    }

//    选择排序
    public void select(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }

//    插入排序
    public void insert(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 4, 9, 1};
        new Sort().insert(a);
        System.out.println(Arrays.toString(a));
    }
}
