public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if (row == 0)
            return;
        int col = matrix[0].length;
        boolean[] b = new boolean[row + col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    b[i] = true;
                    b[row + j] = true;
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i]) {
                if (i < row) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrix[i][j] = 0;
                    }
                }else {
                    for (int j = 0; j < matrix.length; j++) {
                        matrix[j][i - row] = 0;
                    }
                }
            }
        }
    }
}
