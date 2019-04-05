import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> res;
    public int target;
    public int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new LinkedList<>();
        this.target = target;
        this.candidates = candidates;
        if (this.candidates.length == 0)
            return this.res;
        List<Integer> r = new LinkedList<>();
        for (int i = 0; i < candidates.length; i++) {
            r.add(this.candidates[i]);
            this.dg(i, this.candidates[i], r);
            r.remove(0);
        }
        return this.res;
    }

    public void dg(int index, int now, List<Integer> r) {
        if (now == this.target) {
            List<Integer> temp = new LinkedList<>();
            temp.addAll(r);
            this.res.add(temp);
            return;
        }
        if (now > this.target) {
            return;
        }
        for (int i = index; i < this.candidates.length; i++) {
            r.add(this.candidates[i]);
            this.dg(i, now + this.candidates[i], r);
            r.remove(r.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2,3,5}, 8));
    }
}
