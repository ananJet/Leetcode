public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        if (matrix[0].length == 0)
            return false;
        int i = 0; //row
        int j = matrix[0].length - 1; //col
        while (!(i == matrix.length - 1 && j == 0 && matrix[i][j] != target)) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target) {
                j--;
            }else {
                i++;
            }
            if (j < 0 || i > matrix.length - 1)
                return false;
        }
        return false;
    }
}
