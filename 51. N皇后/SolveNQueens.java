import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolveNQueens {

    public List<List<String>> res;
    public int n;
    public int[] poi;

    public List<List<String>> solveNQueens(int n) {
        this.res = new LinkedList<>();
        this.n = n;
        if (this.n == 0)
            return this.res;
        this.poi = new int[this.n];
        for (int i = 0; i < this.poi.length; i++) {
            this.poi[i] = -1;
        }
        for (int i = 0; i < this.n; i++) {
            this.poi[0] = i;
            this.dg(1);
            this.poi[0] = -1;
        }
        return this.res;
    }

    public void dg(int level) {
        if (level == this.n) {
            List<String> r = new LinkedList<>();
            for (int i = 0; i < this.poi.length; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < this.n; j++) {
                    if (j == this.poi[i]) {
                        s.append('Q');
                    }else {
                        s.append('.');
                    }
                }
                r.add(s.toString());
            }
            this.res.add(r);
        }else {
            for (int i = 0; i < this.n; i++) {
                this.poi[level] = i;
                if (this.isWork(level)) {
                    this.dg(level + 1);
                }
                this.poi[level] = -1;
            }
        }
    }

    public boolean isWork(int level) {
        for (int i = 0; i <= level; i++) {
//            向下3个方向看是否有冲突
            for (int j = i + 1; j <= level; j++) {
                if (this.poi[j] == this.poi[i] || this.poi[j] == this.poi[i] + j - i || this.poi[j] == this.poi[i] - (j - i))
                    return false;
            }
        }
        return true;
    }

    public void Test() {
        this.poi = new int[]{3,2,1,0};
        System.out.println(this.isWork(3));
    }

    public static void main(String[] args) {
        System.out.println(new SolveNQueens().solveNQueens(4));
    }
}
