public class EditDistance{
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word1.length(); i++){
        	for(int j = 0; j <= word2.length(); j++){
        		if(i == 0)
        			dp[i][j] = j;
        		else if(j == 0)
        			dp[i][j] = i;
        		else if(word1.charAt(i) == word2.charAt(j))
        			dp[i][j] = dp[i-1][j-1];
        		else{
        			dp[i][j] = Math.min(dp[i-1][j-1], dp[i][j-1]);
        			dp[i][j] = Math.min(dp[i][j], dp[i-1][j]) + 1;
        		}
        	}
        }
        return dp[word1.length()][word2.length()];
    }	
}