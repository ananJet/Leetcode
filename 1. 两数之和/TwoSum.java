import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hashMap.containsKey(nums[i])) {
                return new int[]{hashMap.get(nums[i]), i};
            }
            hashMap.put(temp, i);
        }
        return null;
    }
}
