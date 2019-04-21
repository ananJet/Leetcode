import java.util.Arrays;

public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        int original = Integer.MAX_VALUE;
        int[] min = new int[]{original, original};
        for (int i = 0; i < nums.length; i++) {
//            System.out.println("---------------------");
//            System.out.println(nums[i]);
            if (nums[i] < min[0]) {
                min[0] = nums[i];
//                min[1] = original;
            }else if (nums[i] > min[0] && nums[i] < min[1]) {
                min[1] = nums[i];
            }else if (nums[i] > min[0] && nums[i] > min[1]) {
                return true;
            }
//            System.out.println(Arrays.toString(min));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IncreasingTriplet().increasingTriplet(new int[]{1,2,0,-1,3}));
    }
}
