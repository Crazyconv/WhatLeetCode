public class SearchTwoDMatrixII{
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix != null && matrix.length != 0 && matrix[0].length != 0){
            int rowCount = matrix.length;
            int colCount = matrix[0].length;
            int row = 0, col = colCount - 1;
            while(row <= rowCount - 1 && col >= 0){
                if(matrix[row][col] == target)
                    return true;
                else if(matrix[row][col] < target)
                    row ++;
                else
                    col --;
            }
        }
        return false;
    }    
}