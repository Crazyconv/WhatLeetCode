public class LongestPalindromicSubsequence{
    public void getLPS(String s){
        int[][] t = new int[s.length()][s.length()];
        for(int i = s.length()-1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(i == j)
                    t[i][j] = 1;
                else if(j == i+1)
                    t[i][j] = (s.charAt(i) == s.charAt(j))? 2:1;
                else if(s.charAt(i) == s.charAt(j))
                    t[i][j] = t[i+1][j-1] + 2;
                else
                    t[i][j] = (t[i+1][j] > t[i][j-1])? t[i+1][j] : t[i][j-1];
            }
        }

        //print result
        System.out.printf("LPS[%d]\n", t[0][s.length()-1]);
        String result = null;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbReverse = new StringBuilder();
        int i = 0, j = s.length()-1;
        while(i <= j){
            if(t[i][j] == 1){
                sb.append(s.charAt(i));
                break;
            }
            if(s.charAt(i) == s.charAt(j)){
                sb.append(s.charAt(i));
                sbReverse.append(s.charAt(i));
                i++;
                j--;
            } else if (t[i+1][j] > t[i][j-1]){
                i++;
            } else {
                j--;
            }
        }
        result = sb.toString() + sbReverse.reverse().toString();
        System.out.println(result);
    }
    public static void main(String[] argvs){
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        lps.getLPS("BAAB");
    }
}