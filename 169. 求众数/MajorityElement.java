import java.util.HashMap;

public class MajorityElement {

    public int dc(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];

        int mid = (right + left) / 2;
//        System.out.println(mid);
        int leftMajor = this.dc(nums, left, mid);
//        System.out.println(leftMajor);
        int rightMajor = this.dc(nums, mid + 1, right);

        if (leftMajor == rightMajor)
            return leftMajor;
        else {
//            如果左边和右边不同，遍历整个数组算对应次数
            int countLeft = 0;
            int countRight = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == leftMajor) {
                    countLeft++;
                }else if (nums[i] == rightMajor) {
                    countRight++;
                }
            }
            if (countLeft > countRight) {
                return leftMajor;
            }else if (countLeft < countRight) {
                return rightMajor;
            }else {
                if (Math.random() > 0.5)
                    return leftMajor;
                else
                    return rightMajor;
            }
        }
    }

//    分治法
    public int majorityElement(int[] nums) {
        if (nums.length == 0)
            return 0;
        return this.dc(nums, 0, nums.length - 1);
    }

//    哈希表法
    public int majorityElement1(int[] nums) {
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

//    摩尔投票法
    public int majorityElement2(int[] nums) {
        int count = 1;
        int result = nums[0]; //candidate
        for (int i = 1; i < nums.length; i++) {
            if (result == nums[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    result = nums[i];
                    count = 1;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement2(new int[]{1,1,1,2,2,2,1,3}));
    }
}
