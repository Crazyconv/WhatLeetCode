public class LongestRepeatedSubsequence{
    /**********************************************************************
     **                        Dynamic Programming                       **
     **********************************************************************/
    // O(nm)
    public void findLRS(String s){
        int[][] lrs = new int[s.length()+1][s.length()+1];
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j <= s.length(); j++){
                if(i == 0 || j == 0)
                    lrs[i][j] = 0;
                else if (s.charAt(i-1) == s.charAt(j-1) && i != j){
                    lrs[i][j] = lrs[i-1][j-1] + 1;
                }else{
                    lrs[i][j] = (lrs[i-1][j] > lrs[i][j-1])? lrs[i-1][j]:lrs[i][j-1];
                }
            }
        }

        // print result
        int i = s.length(), j = i;
        if(lrs[i][j] < 1){
            System.out.println("No LRS.");
        } else {
            StringBuilder sb = new StringBuilder();
            System.out.printf("LRS[%d]: ", lrs[i][j]);
            while(true){
                if(i != j && s.charAt(i-1) == s.charAt(j-1)){
                    sb.append(s.charAt(i-1));
                    if(lrs[i][j] == 1)
                        break;
                    i--;
                    j--;
                } else if(lrs[i-1][j] >= lrs[i][j-1]){
                    i--;
                } else{
                    j--;
                }
            }
            System.out.println(sb.reverse().toString());
        }
    }
    public static void main(String[] argvs){
        LongestRepeatedSubsequence lrs = new LongestRepeatedSubsequence();
        lrs.findLRS("ab");
    }    
}