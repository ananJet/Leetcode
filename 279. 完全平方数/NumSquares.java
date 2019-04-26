public class NumSquares {

    public int res;
    public int[] record;

    public int numSquares(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        this.res = Integer.MAX_VALUE;
        this.record = new int[n + 1];
        this.dg(n, (int) Math.sqrt(n), 0);
        return res;
    }

    public void dg(int num, int len, int r) {
//        System.out.println(len);
//        System.out.println(num + "\t" + r);
        if (num == 0) {
            if (r < this.res)
                this.res = r;
            return;
        }
        if (r > this.res)
            return;
        if (this.record[num] == 0) {
            this.record[num] = r;
        }else if (this.record[num] <= r) {
            return;
        }else if (this.record[num] > r) {
            this.record[num] = r;
        }
        for (int i = len; i >= 1; i--) {
            int temp = num - i * i;
//            System.out.println("haha");
            this.dg(temp, (int) Math.sqrt(temp), r + 1);
        }
    }

    public static void main(String[] args) {
        new NumSquares().numSquares(7168);
    }
}
