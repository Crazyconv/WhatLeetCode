public class LongestCommonSubstring{
    /**********************************************************************
     **                     Dynamic Programming                          **
     **********************************************************************/
    // O(nm)
    public void getLCS(String s, String p){
        int maxStartIndex = 0, maxLength = 0;
        int[][] t = new int[s.length()+1][p.length()+1];
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j <= p.length(); j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                } else if(s.charAt(i-1) == p.charAt(j-1)){
                    t[i][j] = t[i-1][j-1] + 1;
                    if(t[i][j] > maxLength){
                        maxLength = t[i][j];
                        maxStartIndex = i - maxLength;
                    }
                } else {
                    t[i][j] = 0;
                }
            }
        }
        if(maxLength > 0)
            System.out.printf("LCS[%d]: %s\n", maxLength, s.substring(maxStartIndex, maxStartIndex + maxLength));
        else
            System.out.println("No LCS.");
    }    
    /**********************************************************************
     **                              Suffix Tree                         **
     **********************************************************************/
    // O(n+m)
    
    public static void main(String[] argvs){
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        lcs.getLCS("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com");
    }
}