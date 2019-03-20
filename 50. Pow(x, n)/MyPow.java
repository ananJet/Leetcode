import java.util.HashMap;

public class MyPow {

    public HashMap<Integer, Double> record;
    public double target;

    //递归函数
    public double pow(int e) {
        if (this.record.containsKey(e))
            return this.record.get(e);
        double res = 0;
        boolean flag = false;
//        如果是奇数，flag = true
        if ((e & 1) == 1)
            flag = true;
        if (flag) {
            int temp = (e - 1) >> 1;
            double temp_res = this.pow(temp);
            res = temp_res * temp_res * this.record.get(1);
        }else {
            int temp = e >> 1;
            double temp_res = this.pow(temp);
            res = temp_res * temp_res;
        }
        this.record.put(e, res);
        return res;
    }

    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE)
            return Math.abs(x) == 1 ? 1.0 : 0.0;
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        if (n < 0) {
            n = 0-n;
            x = 1.0 / x;
        }
        this.record = new HashMap<>();
        this.target = x;
        this.record.put(1 ,this.target);
        return this.pow(n);
    }

    public double myPow1(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return Math.abs(x) == 1 ? 1.0 : 0.0;
        }
        if (n < 0) {
            return 1.0 / myPow1(x, -n);
        }
        if (n == 0) {
            return 1.0;
        }
        double r = myPow1(x, n / 2);
        return n % 2 == 1 ? r * x * r : r * r;
    }

    public double myPow2(double x, int n) {
        if(n==0) return 1;
        double res = 1;
        if(n==0) return x;
        long len = Math.abs((long)n);
        while(len!=0){
            if((len&1) == 1) res*=x;
            x = x*x;
            len = len>>1;
        }
        return n<=0?1/res:res;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(1, -2147483648));
    }
}
