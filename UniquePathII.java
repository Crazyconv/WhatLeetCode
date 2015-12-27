public class UniquePathII{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid != null && obstacleGrid.length > 0 && obstacleGrid[0].length > 0){
            int rowNum = obstacleGrid.length;
            int colNum = obstacleGrid[0].length;
            int[] nums = new int[rowNum];
            for(int j = 0; j < colNum; j++){
                for(int i = 0; i < rowNum; i++){
                    if(obstacleGrid[i][j] == 1)
                        nums[i] = 0;
                    else if(j == 0){
                        nums[i] = (i == 0 || nums[i-1] == 1)? 1:0;
                    } else if(i > 0){
                        nums[i] = nums[i] + nums[i-1];
                    }
                }
            }
            return nums[rowNum-1];
        }
        return 0;
    }
}