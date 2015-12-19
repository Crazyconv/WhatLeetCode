public class SetMatrixZeroes{
    public void setZeroes(int[][] matrix) {
        if(matrix != null){
            boolean firstRowZero = false;
            boolean firstColZero = false;
            int rowNum = matrix.length;
            if(rowNum != 0 && matrix[0].length != 0){
                int colNum = matrix[0].length;
                for(int i = 0; i < rowNum; i++){
                    if(matrix[i][0] == 0)
                        firstColZero = true;
                }
                for(int j = 0; j < colNum; j++){
                    if(matrix[0][j] == 0)
                        firstRowZero = true;
                }
                for(int i = 1; i < rowNum; i++){
                    for(int j = 1; j < colNum; j++){
                        if(matrix[i][j] == 0){
                            matrix[i][0] = 0;
                            matrix[0][j] = 0;
                        }
                    }
                }
                for(int i = 1; i < rowNum; i++){
                    if(matrix[i][0] == 0){
                        for(int j = 1; j < colNum; j++){
                            matrix[i][j] = 0;
                        }
                    }
                }
                for(int j = 1; j < colNum; j++){
                    if(matrix[0][j] == 0){
                        for(int i = 1; i < rowNum; i++){
                            matrix[i][j] = 0;
                        }
                    }
                }
                if(firstColZero){
                    for(int i = 0; i < rowNum; i++){
                        matrix[i][0] = 0;
                    }
                }
                if(firstRowZero){
                    for(int j = 0; j < colNum; j++){
                        matrix[0][j] = 0;
                    }
                }
            }
        }
    }    
}