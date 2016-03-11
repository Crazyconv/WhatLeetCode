public class WordBreak{
    // 1ms
    // add minLength/maxLength restriction not improving
    // DP
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0)
            return true;
        if(wordDict.size() == 0)
            return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length() && !dp[i]; i++){
            for(int j = i - 1; j >= 0; j--){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    } 

    // 2ms
    // add minLength/maxLength restriction improving
    // BFS
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0)
            return true;
        if(wordDict.size() == 0)
            return false;

        int minLength = Integer.MAX_VALUE;
        int maxLength = 0;

        // this reduce the search space
        for(String p : wordDict){
            int len = p.length();
            if(len > maxLength) maxLength = len;
            if(len < minLength) minLength = len;
        }

        boolean[] dp = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            for(int j = minLength; j <= maxLength && i+j <= s.length(); j++){
                if(!dp[i+j-1]){
                    if(wordDict.contains(s.substring(i, i+j))){
                        dp[i+j-1] = true;
                        if(i+j == s.length())
                            return true;
                    }
                }
            }
            // this reduce the search space
            while(i < s.length() && !dp[i]){
                i++;
            }
        }
        return dp[s.length()-1];
    }   
}