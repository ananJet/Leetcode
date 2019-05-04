public class HasAlternatingBits {

    public boolean hasAlternatingBits(int n) {
//        将正整数转换为二进制数的过程中判断是否相邻为相等
        int last = -1;
        while (n > 0) {
            int a = n % 2;
            if (a == last)
                return false;
            else
                last = a;
            n /= 2;
        }
        return true;
    }
}
