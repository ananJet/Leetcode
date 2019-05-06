public class IntegerBreak {
    public int integerBreak(int n) {
//        将问题转换为有多少个2和多少个3组成和
        if (n < 3)
            return 1;
        if (n == 3)
            return 2;

        int num2 = 0;
        int num3 = 0;
        while (true) {
            if (n == 4) {
                num2 += 2;
                break;
            }else if (n == 2) {
                num2++;
                break;
            }else if (n == 0) {
                break;
            }
            n -= 3;
            num3++;
        }

        int res = 1;
        for (int i = 0; i < num3; i++) {
            res *= 3;
        }
        for (int i = 0; i < num2; i++) {
            res *= 2;
        }
        return res;
    }
}
