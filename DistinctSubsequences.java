public class DistinctSubsequences{
    public int numDistinct(String s, String t){
        if(s == null || t == null)
            return 0;

        int sLen = s.length() + 1;
        int tLen = t.length() + 1;
        int[][] dp = new int[sLen][tLen];

        for(int i = 0; i < sLen; i++){
            for(int j = 0; j < tLen; j++){
                if(j == 0)
                    dp[i][j] = 1;
                else if(i == 0)
                    dp[i][j] = 0;
                else if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j]; 
            }
        }
        return dp[sLen-1][tLen-1];
    }
    public static void main(String[] argvs){
        DistinctSubsequences ds = new DistinctSubsequences();
        System.out.println(ds.numDistinct("rabbbit", "rabbit"));
    }
}