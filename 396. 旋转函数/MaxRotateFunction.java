import java.util.Arrays;

public class MaxRotateFunction {

    public int maxRotateFunction(int[] A) {
        if (A.length < 2)
            return 0;
//        ���������
        int sum = 0;
        int last = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            last += i * A[i];
        }

        int res = last;
        for (int i = 1; i < A.length; i++) {
            int temp = last + sum - A[A.length - i] * A.length;
            if (temp > res)
                res = temp;
            last = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        new MaxRotateFunction().maxRotateFunction(new int[]{4,3,2,6});
    }
}
