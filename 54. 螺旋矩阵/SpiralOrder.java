import java.util.LinkedList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix.length == 0)
            return result;
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                result.add(matrix[i][0]);
            }
            return result;
        }
        int flag = 0; //0代表1趟，1代表2趟，2代表3趟，3代表4趟
        int[] trans = new int[]{0, 0};
        int[] end = new int[]{matrix[0].length - 1, matrix.length - 1, 0, 0};
        result.add(matrix[0][0]);
        while (true) {
            boolean o = false;
            switch (flag) {
                case 0:
                    for (int i = trans[1] + 1; i <= end[flag]; i++) {
                        result.add(matrix[trans[0]][i]);
                        o = true;
                    }
                    trans[1] = end[flag];
                    flag++;
                    end[3] += 1;
                    break;
                case 1:
                    for (int i = trans[0] + 1; i <= end[flag]; i++) {
                        result.add(matrix[i][trans[1]]);
                        o = true;
                    }
                    trans[0] = end[flag];
                    flag++;
                    end[0] -= 1;
                    break;
                case 2:
                    for (int i = trans[1] - 1; i >= end[flag]; i--) {
                        result.add(matrix[trans[0]][i]);
                        o = true;
                    }
                    trans[1] = end[flag];
                    flag++;
                    end[1] -= 1;
                    break;
                case 3:
                    for (int i = trans[0] - 1; i >= end[flag]; i--) {
                        result.add(matrix[i][trans[1]]);
                        o = true;
                    }
                    trans[0] = end[flag];
                    flag = 0;
                    end[2] += 1;
                    break;
            }
            if (!o)
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(new SpiralOrder().spiralOrder(a));
    }
}
