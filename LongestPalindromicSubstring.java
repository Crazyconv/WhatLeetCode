public class LongestPalindromicSubstring{
    public static void main(String[] argvs){
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindromeDP("abbac"));
    }
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";
        int longest = 0, start = -1, end = -1;
        for(int i = 0; i < s.length()-1; i++){
            for(int j = 1; j <= 2 && i+j < s.length(); j ++){
                int n = i + j;
                int m = i;
                while(m >= 0 && n <= s.length() - 1){
                    if(s.charAt(m) != s.charAt(n))
                        break;
                    else{
                        m--; n++;
                    }
                }
                int length = n - m - 1;
                if(length > longest){
                    longest = length;
                    start = m + 1;
                    end = n - 1;
                }
            }
        }
        if(start == -1)
            return s.substring(0,1);
        else
            return s.substring(start, end+1);
    } 
    public String longestPalindromeDP(String s) {
        // i,i: true
        // i,i+1: true if s[i] == s[i+1]
        // i,j: true if s[i] == s[j] && value[i+1][j-1] is true
        if(s == null || s.length() == 0)
            return "";
        boolean[][] value = new boolean[s.length()][s.length()];
        int longest = 0, start = -1, end = -1;
        for(int i = s.length()-1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(j == i)
                    value[i][j] = true;
                else if(j == i+1)
                    value[i][j] = (s.charAt(i) == s.charAt(j));
                else
                    value[i][j] = (s.charAt(i) == s.charAt(j)) && (value[i+1][j-1]);
                if(value[i][j]){
                    int length = j-i+1;
                    if(length > longest){
                        longest = length;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        if(start == -1)
            return s.substring(0,1);
        else
            return s.substring(start, end+1);
    }   
}