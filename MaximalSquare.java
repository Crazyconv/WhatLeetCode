public class MaximalSquare{
    public int maximalSquare(char[][] matrix) {
        if(matrix != null && matrix.length != 0 && matrix[0].length != 0){
            int max = 0;
            int[][] result = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i ++){
                for(int j = 0; j < matrix[0].length; j ++){
                    if(matrix[i][j] == '0')
                        result[i][j] = 0;
                    else{
                        if(i == 0 || j == 0)
                            result[i][j] = 1;
                        else{
                            int min = (result[i-1][j] < result[i][j-1])? result[i-1][j]:result[i][j-1];
                            min = (min < result[i-1][j-1])? min:result[i-1][j-1];
                            result[i][j] = min + 1;
                        }
                        if(result[i][j] > max)
                            max = result[i][j];
                    }
                }
            }
            return max * max;
        }
        return 0;
    }    
}