public class ScrambleString{
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s1.length() == 0)
        	return true;
        // dp[k][i][j]: len k string starting at s1.i, s2.j
        boolean[][][] dp = new boolean[s1.length()+1][s1.length()][s1.length()];
        for(int i = 0; i < s1.length(); i++){
        	for(int j = 0; j < s2.length(); j++){
        		dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
        	}
        }
        for(int k = 2; k <= s1.length(); k++){
        	for(int i = 0; i + k <= s1.length(); i++){
        		for(int j = 0; j + k <= s2.length(); j++){
        			for(int first = 1; first < k ; first ++){
        				if(dp[first][i][j] && dp[k - first][first + i][first + j] ||
        					dp[first][i][j + k - first] && dp[k - first][i + first][j]){
        					dp[k][i][j] = true;
        					break;
        				}
        			}
        			dp[k][i][j] = false;
        		}
        	}
        }
        return dp[s1.length()][0][0];
    }	

    // recurive + prune + dp
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s1.length == 0)
        	return true;
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int[][][] dp = new int[cs1.length + 1][cs1.length][cs1.length];
        return isScramble(cs1, cs2, cs1.length, 0, 0, dp) == 1;
    }  

    public int isScramble(char[] cs1, char[] cs2, int len, int i, int j, int[][][] dp){
    	if(dp[len][i][j] != 0) 
    		return dp[len][i][j];

    	int[] count = new int[256];
    	boolean same = true;
    	for(int a = 0; a < len; a ++){
    		if(cs1[i+a] != cs2[j+a])
    			same = false;
    		count[cs1[i+a]] ++;
    		count[cs2[j+a]] --;
    	}
    	if(same) 
    		return dp[len][i][j] = 1;
    	for(int a = 0; a < 256; a ++){
    		if(count[a] != 0)
    			return dp[len][i][j] = -1;
    	}

    	for(int a = 1; a < len; a++){
    		if(isScramble(cs1, cs2, a, i, j, dp) == 1 && isScramble(cs1, cs2, len - a, a + i, a + j) == 1 ||
    			isScramble(cs1, cs2, a, i, j + len - a) == 1 && isScramble(cs1, cs2, len - a, a + i, j) == 1)
    			return dp[len][i][j] = 1;
    	}
    	return dp[len][i][j] = -1;
    }  
}