public class RangeSumQuery2DImmutable{
    int[][] sum;
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if(matrix != null && matrix.length > 0 && matrix[0].length > 0){
            int rowNum = matrix.length;
            int colNum = matrix[0].length;
            this.sum = new int[rowNum + 1][colNum + 1];
            for(int i = 1; i <= rowNum; i++){
                for(int j = 1; j <= colNum; j++){
                    sum[i][j] = sum[i][j - 1] + matrix[i - 1][j - 1];
                }
            }
            for(int j = 1; j <= colNum; j++){
                for(int i = 1; i <= rowNum; i++){
                    sum[i][j] += sum[i - 1][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }    
}