import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PancakeSort {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int max = i;
            for (int j = i; j >= 0; j--) {
                if (A[j] > A[max])
                    max = j;
            }
            this.reverse(A, max, i);
            list.add(max + 1);
            list.add(i + 1);
        }
        return list;
    }

    public void reverse(int[] A, int k, int l) {
        for (int i = 0; i <= k / 2; i++) {
            int temp = A[i];
            A[i] = A[k - i];
            A[k - i] = temp;
        }
        for (int i = 0; i <= l / 2; i++) {
            int temp = A[i];
            A[i] = A[l - i];
            A[l - i] = temp;
        }
    }



    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 4, 1};
        new PancakeSort().pancakeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
