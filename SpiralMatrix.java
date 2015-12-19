public class SpiralMatrix{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix != null && matrix.length != 0){
            int rowStart = 0, colStart = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
            while(rowStart <= rowEnd && colStart <= colEnd){
                for(int j = colStart; j <= colEnd; j++){
                    result.add(matrix[rowStart][j]);
                }
                if(rowStart < rowEnd){
                    for(int i = rowStart+1; i <= rowEnd; i++){
                        result.add(matrix[i][colEnd]);
                    }
                    if(colStart < colEnd){
                        for(int j = colEnd-1; j >= colStart; j--){
                            result.add(matrix[rowEnd][j]);
                        }
                        for(int i = rowEnd-1; i >= rowStart+1; i--){
                            result.add(matrix[i][colStart]);
                        }
                    }
                }
                rowStart ++;
                rowEnd --;
                colStart ++;
                colEnd --;
            }
        }
        return result;
    }    
}