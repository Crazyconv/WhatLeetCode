public class RotateImage{
    public void rotate(int[][] matrix) {
        if(matrix != null && matrix.length != 0){
            int n = matrix.length;
            for(int i = 0; i < n/2; i ++){
                for(int j = i; j < n - 1 - i; j++){
                    int temp = matrix[n-1-j][i];
                    matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                    matrix[j][n-1-i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }    
    }
    public static void main(String[] argvs){
        RotateImage ri = new RotateImage();
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        ri.rotate(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}