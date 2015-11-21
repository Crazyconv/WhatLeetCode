public class LongestCommonSubsequence{
    /**********************************************************************
     **                        Dynamic Programming                       **
     **********************************************************************/
    // O(nm)
    public void findLCS(String s, String p){
        int[][] lcs = new int[s.length()+1][p.length()+1];
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j <= p.length(); j++){
                if(i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if (s.charAt(i-1) == p.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }else{
                    lcs[i][j] = (lcs[i-1][j] > lcs[i][j-1])? lcs[i-1][j]:lcs[i][j-1];
                }
            }
        }

        // print result
        int i = s.length(), j = p.length();
        if(lcs[i][j] < 1){
            System.out.println("No LCS.");
        } else{
            StringBuilder sb = new StringBuilder();
            System.out.printf("LCS[%d]: ", lcs[i][j]);
            while(true){
                if(s.charAt(i-1) == p.charAt(j-1)){
                    sb.append(s.charAt(i-1));
                    if(lcs[i][j] == 1)
                        break;
                    i--;
                    j--;
                } else if(lcs[i-1][j] >= lcs[i][j-1]){
                    i--;
                } else{
                    j--;
                }
            }
            System.out.println(sb.reverse().toString());
        }
    }
    public static void main(String[] argvs){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        lcs.findLCS("abcd", "efgh");
    }    
}