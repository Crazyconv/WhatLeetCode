public class MinimumPathSum{
    public int minPathSum(int[][] grid) {
        if(grid != null && grid.length != 0 && grid[0].length != 0){
            int rowNum = grid.length;
            int colNum = grid[0].length;
            int[] sums = new int[rowNum];
            for(int j = 0; j < colNum; j++){
                for(int i = 0; i < rowNum; i++){
                    if(j == 0){
                        if(i == 0)
                            sums[i] = grid[i][j];
                        else
                            sums[i] = sums[i-1] + grid[i][j];
                    } else {
                        if(i == 0 || sums[i] < sums[i-1])
                            sums[i] = sums[i] + grid[i][j];
                        else
                            sums[i] = sums[i-1] + grid[i][j];
                    }
                }
            }
            return sums[rowNum-1];
        }
        return 0;
    }    
}