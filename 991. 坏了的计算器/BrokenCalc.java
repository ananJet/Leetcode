public class BrokenCalc {
    public int brokenCalc(int X, int Y) {
        if (Y <= X)
            return X - Y;
        int res = 0;
        while (X < Y) {
            if ((Y & 1) == 0) {
                Y /= 2;
                res++;
            }else {
                Y += 1;
                Y /= 2;
                res += 2;
            }
        }
        return res + X - Y;
    }

    public static void main(String[] args) {
        System.out.println(new BrokenCalc().brokenCalc(1, 1000000000));
    }
}
