public class PalindromePartitioningII{
    // dp using array only
    // space: O(n) time: O(n^2)
    public int minCut(String s){
        if(s == null || s.length() <= 1)
            return 0;
        int len = s.length();
        int[] min = new int[len + 1];
        for(int i = 0; i <= len; i++){
            min[i] = i - 1;
        }

        for(int i = 0; i < len; i++){
            for(int j = 0; i - j >= 0 && i + j < len && s.charAt(i - j) == s.charAt(i + j); j++){
                min[i + j + 1] = Math.min(min[i + j + 1], min[i - j] + 1);
            }
            for(int j = 1; i - j + 1 >= 0 && i + j < len && s.charAt(i - j + 1) == s.charAt(i + j); j++){
                min[i + j + 1] = Math.min(min[i + j + 1], min[i - j + 1] + 1);
            }
        }
        return min[len];
    }

    // // dp using table 
    // // space: O(n^2) time: O(n^2)
    // public int minCut(String s) {
    //     if(s == null || s.length() <= 1)
    //         return 0;
    //     boolean[][] isPal = buildTable(s);
    //     int[] min = new int[s.length()];
    //     min[0] = 0;

    //     for(int i = 1; i < s.length(); i++){
    //         if(isPal[0][i])
    //             min[i] = 0;
    //         else{
    //             min[i] = s.length();
    //             for(int j = i - 1; j >= 0; j--){
    //                 if(isPal[j+1][i] && min[j] + 1 < min[i])
    //                     min[i] = min[j] + 1;
    //             }
    //         }
    //     }
    //     return min[s.length() - 1];
    // }
    // public boolean[][] buildTable(String s){
    //     boolean[][] dp = new boolean[s.length()][s.length()];
    //     for(int i = s.length() - 1; i >= 0; i--){
    //         for(int j = i; j < s.length(); j++){
    //             if(j == i)
    //                 dp[i][j] = true;
    //             else if(j == i + 1)
    //                 dp[i][j] = s.charAt(i) == s.charAt(j);
    //             else
    //                 dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
    //         }
    //     }
    //     return dp;
    // }
    public static void main(String[] argvs){
        PalindromePartitioningII pp = new PalindromePartitioningII();
        System.out.println(pp.minCut("ababbbabbababa"));
    }    
}