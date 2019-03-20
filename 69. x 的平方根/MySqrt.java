public class MySqrt {
    public int mySqrt(int x) {
        if (x == 1)
            return 1;
        int temp = 0;
        int up = 46340;
        int low = temp;
        int mid = -1;
        while (low <= up) {
            mid = (up  - low) / 2 + low;
//            System.out.println(mid);
            int ch = mid * mid;
            if (ch > x) {
                up = mid - 1;
            }else if (ch < x) {
                low = mid + 1;
            }else {
                return mid;
            }
        }
        int t = mid * mid;
        if (t > x)
            return mid - 1;
        else
            return mid;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        System.out.println(new MySqrt().mySqrt(2147395599));
    }
}
