public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            n = n / 5;
            res += n;
        }
        return res;
    }

    public static void main(String[] args) {
        int input = 10;
        double res = 1;
        for (int i = input; i > 0; i--) {
            res = res * i;
        }
        System.out.println(new TrailingZeroes().trailingZeroes(25));
    }
}
