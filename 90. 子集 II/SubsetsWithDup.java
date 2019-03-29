import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup {
    public int[] nums;
    public List<List<Integer>> res;
    public boolean[] passed;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.res = new LinkedList<>();
        this.nums = nums;
        this.passed = new boolean[this.nums.length];
        if (this.nums.length == 0)
            return this.res;
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
//                System.out.println("--------------------------");
//                System.out.println(list);
//                System.out.println(index);
//                System.out.println(i);
//                System.out.println(this.isDup(list, index, i));
//                System.out.println(this.res);
                if (!this.isDup(list, index, i)) {
                    list.add(this.nums[i]);
                    this.passed[i] = true;
                    List<Integer> temp = new LinkedList<>();
                    temp.addAll(list);
                    this.res.add(temp);
                    this.dg(i + 1, list);
                    this.passed[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public boolean isDup(List<Integer> list, int begin, int target) {
        boolean flag = false;
        //        当前遍历到的数字在前面是否已经出现过
        for (int i = begin; i < target; i++) {
            if (this.nums[i] == this.nums[target])
                flag = true;
        }
        if (list.size() == 0)
            return flag;
        for (int i = begin - 1; i >= 0; i--) {
            if (!this.passed[i] && this.nums[i] == this.nums[target]) {
                flag = true;
                break;
            }
        }
//        int ahead = -1;
//        for (int i = 0; i < this.nums.length; i++) {
//            if (this.nums[i] == temp) {
//                ahead = i;
//                break;
//            }
//        }
//        for (int i = 0; i < ahead; i++) {
//            if (this.nums[i] == this.nums[target])
//                flag = true;
//        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{1,2,2}));
    }
}
