public class SpiralMatrixII{
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int cur = 1;
        if(n >= 1){
            int rowStart = 0, colStart = 0, rowEnd = n - 1, colEnd = n - 1;
            while(rowStart <= rowEnd && colStart <= colEnd){
                for(int j = colStart; j <= colEnd; j++){
                    matrix[rowStart][j] = cur++;
                }
                if(rowStart < rowEnd){
                    for(int i = rowStart+1; i <= rowEnd; i++){
                        matrix[i][colEnd] = cur++;
                    }
                    if(colStart < colEnd){
                        for(int j = colEnd-1; j >= colStart; j--){
                            matrix[rowEnd][j] = cur++;
                        }
                        for(int i = rowEnd-1; i >= rowStart+1; i--){
                            matrix[i][colStart] = cur++;
                        }
                    }
                }
                rowStart ++;
                rowEnd --;
                colStart ++;
                colEnd --;
            }
        }
        return matrix;
    }    
}