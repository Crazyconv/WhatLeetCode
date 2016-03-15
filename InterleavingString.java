public class InterleavingString{
	// DP
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s3.length() != s1.length() + s2.length())
    		return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++){
        	for(int j = 0; j <= s2.length(); j++){
        		if(i == 0 && j == 0)
        			dp[i][j] = true;
        		else{ 
        			if(j > 0)
        				dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
        		    if(i > 0)
        				dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
        		}
        	}
        }
        return dp[s1.length()][s2.length()];
    }	
    // BFS
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s3.length() != s1.length() + s2.length())
    		return false;
    	boolean[][] visited = new boolean[s1.length() + 1][s2.length() + 1];
    	Queue<Integer> q1 = new LinkedList<Integer>();
    	Queue<Integer> q2 = new LinkedList<Integer>();
    	q1.offer(0);
    	q2.offer(0);
    	visited[0][0] = true;
    	while(q1.size() > 0){
    		int i1 = q1.poll();
    		int i2 = q2.poll();
    		if(i1 == s1.length() && i2 == s2.length())
    			return true;
    		// right
    		if(i1 + 1 <= s1.length() && !visited[i1 + 1][i2] && s1.charAt(i1) == s3.charAt(i1 + i2)){
    			visited[i1 + 1][i2] = true;
    			q1.offer(i1 + 1);
    			q2.offer(i2);
    		}
    		if(i2 + 1 <= s2.length() && !visited[i1][i2 + 1] && s2.charAt(i2) == s3.charAt(i1 + i2)){
    			visited[i1][i2 + 1] = true;
    			q1.offer(i1);
    			q2.offer(i2 + 1);
    		}    		
    	}
    	return false;
    }
}