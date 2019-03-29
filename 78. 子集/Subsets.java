import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public int[] nums;
    public boolean[] passed;
    public List<List<Integer>> res;

    public List<List<Integer>> subsets1(int[] nums) {
        this.res = new LinkedList<>();
        this.nums = nums;
        if (this.nums.length == 0)
            return this.res;
        this.passed = new boolean[this.nums.length];
        List<Integer> list = new LinkedList<>();
        this.res.add(new LinkedList<>());
        this.dg(0, list);
        return this.res;
    }

    public void dg(int index, List<Integer> list) {
        if (index == this.nums.length) {
            return;
        }else {
            for (int i = index; i < this.nums.length; i++) {
                if (!this.passed[i]) {
                    list.add(this.nums[i]);
                    this.passed[i] = true;
                    List<Integer> temp = new LinkedList<>();
                    temp.addAll(list);
                    this.res.add(temp);
                    this.dg(i + 1, list);
                    list.remove(list.size() - 1);
                    this.passed[i] = false;
                }
            }
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.res = new LinkedList<>();
        this.nums = nums;
        if (this.nums.length == 0)
            return this.res;
        List<Integer> list = new LinkedList<>();
        this.res.add(new LinkedList<>());
        for (int i = nums.length - 1; i >= 0; i--) {
            List<Integer> temp = new LinkedList<>();
            int n = this.res.size();
            for (int j = 0; j < n; j++) {
                List<Integer> r = this.res.get(j);
                temp = new LinkedList<>();
                temp.addAll(r);
                temp.add(nums[i]);
                this.res.add(temp);
            }
        }
        return this.res;
    }

    public static void main(String[] args) {
        new Subsets().subsets(new int[]{1, 2, 3});
    }


}
