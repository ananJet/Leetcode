import java.util.LinkedList;
import java.util.List;

public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.abs(nums[i]) - 1;
            if (nums[temp] > 0) {
                nums[temp] = -nums[temp];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                result.add(i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindDisappearedNumbers().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
