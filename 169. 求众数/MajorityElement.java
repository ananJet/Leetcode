import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n2 = nums.length / 2;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = hashmap.getOrDefault(nums[i], 0) + 1;
            if (temp >= n2) {
                return nums[i];
            }
            hashmap.put(nums[i], temp);
        }
        return -1;
    }

    public int majorityElement1(int[] nums) {
        int count=1;
        int res=nums[0];
        for(int i=1; i<nums.length; i++){
            if(res==nums[i])
                count++;
            else{
                count--;
                if(count==0)
                    res=nums[i+1];
            }
        }
        return res;
    }
}
