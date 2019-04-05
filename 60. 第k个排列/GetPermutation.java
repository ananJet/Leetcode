import java.util.Arrays;

public class GetPermutation {

    public int n;
    public int k;
    public int count;
    public boolean[] passed;
    public String res;


    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        this.count = 0;
        StringBuilder s = new StringBuilder();
        this.passed = new boolean[this.n];
        for (int i = 0; i < this.n; i++) {
            if (this.count < this.k) {
                s.append(i + 1);
                this.passed[i] = true;
                this.dg(s, 1);
                this.passed[i] = false;
                s.deleteCharAt(s.length() - 1);
            }
        }
        return this.res;
    }

    public void dg(StringBuilder s, int len) {
        if (len == this.n) {
            this.count++;
            if (this.count == this.k)
                this.res = s.toString();
        }else {
            if (this.count < this.k) {
                for (int i = 0; i < this.n; i++) {
                    if (!this.passed[i]) {
                        s.append(i + 1);
                        this.passed[i] = true;
                        this.dg(s, len + 1);
                        this.passed[i] = false;
                        s.deleteCharAt(s.length() - 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new GetPermutation().getPermutation(3, 3));
    }
}
