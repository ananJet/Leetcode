import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique {

    public List<List<Integer>> res;
    public int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.res = new LinkedList<>();
        this.nums = nums;
        boolean[] passed = new boolean[this.nums.length];
        int[] nums_online = new int[this.nums.length];
        this.bt(nums_online, 0, passed);
        return this.res;
    }

    public void bt(int[] nums_online, int index, boolean[] passed) {
        if (index == nums_online.length) {
            List<Integer> r = new LinkedList<>();
            for (int i = 0; i < nums_online.length; i++)
                r.add(nums_online[i]);
            this.res.add(r);
        }else {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 0; i < passed.length; i++) {
                if (!passed[i] && !hashSet.contains(this.nums[i])) {
                    nums_online[index] = this.nums[i];
                    passed[i] = true;
                    this.bt(nums_online, index + 1, passed);
                    passed[i] = false;
                    hashSet.add(this.nums[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{2,2,1,1}));
    }
}
