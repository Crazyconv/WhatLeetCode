public class DungeonGame{
    public int calculateMinimumHP(int[][] dungeon) {
        int result = 0;
        if(dungeon != null && dungeon.length > 0 && dungeon[0].length > 0){
            int row = dungeon.length;
            int col = dungeon[0].length;
            int[][] dp = new int[row][col];
            for(int i = row - 1; i >= 0; i--){
                for(int j = col - 1; j >= 0; j--){
                    if(i == row - 1 && j == col - 1)
                        dp[i][j] = 1 - dungeon[i][j];
                    else if(i == row - 1)
                        dp[i][j] = dp[i][j+1] - dungeon[i][j];
                    else if(j == col - 1)
                        dp[i][j] = dp[i+1][j] - dungeon[i][j];
                    else
                        dp[i][j] = ((dp[i][j+1] < dp[i+1][j])? dp[i][j+1] : dp[i+1][j]) - dungeon[i][j];
                    if(dp[i][j] < 1)
                        dp[i][j] = 1;
                }
            }
            result = dp[0][0];
        }
        return result;
    }    
}