import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permute {

    public List<List<Integer>> res;
    public int[] nums;

    public List<List<Integer>> permute(int[] nums) {
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
            for (int i = 0; i < passed.length; i++) {
                if (!passed[i]) {
                    nums_online[index] = this.nums[i];
                    passed[i] = true;
                    this.bt(nums_online, index + 1, passed);
                    passed[i] = false;
                }
            }
        }
    }

//    public List<List<Integer>> res;

    public List<List<Integer>> permute1(int[] nums) {
        this.res = new LinkedList<>();
        this.bt(nums, 0);
        return this.res;
    }

    public void bt(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            this.res.add(list);
        }else {
            for (int i = index + 1; i < nums.length; i++) {
                this.swap(nums, index, i);
                this.bt(nums, index + 1);
                this.swap(nums, index, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
