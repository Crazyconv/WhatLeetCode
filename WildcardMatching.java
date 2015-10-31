public class WildcardMatching{
    /* greedy */
    public boolean isMatchGreedy(String s, String p){
        if(s == null || p == null)
            return false;
        int sLen = s.length();
        int pLen = p.length();
        int i = 0, j = 0;
        int sRe = 0, pRe = 0;
        boolean star = false;
        while(i < sLen){
            if(j < pLen && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))){
                i++;
                j++;
            } else if (j < pLen && p.charAt(j) == '*'){
                while(j < pLen && p.charAt(j) == '*'){
                    j++;
                }
                pRe = j;
                sRe = i;
                star = true;
            } else if (star){
                sRe ++;
                i = sRe;
                j = pRe;
            } else {
                return false;
            }
        }
        while(j < pLen && p.charAt(j) == '*')
            j++;
        if(j != pLen)
            return false;
        else
            return true;
    }
    /* flag[i][j] = flag[i-1][j-1]: p[j-1] == '?' || s[i-1] == p[j-1]
     *            = flag[i][j-1] | flag[i-1][j-1] | flag[i-2][j-1] | ... = flag[i][j-1] | flag[i-1][j]: p[j-1] == '*'
     *            = false: otherwise
     * flag[i][0] = true: i == 0; 
     *            = false: i != 0
     * flag[0][j] = true: j == 0 || (p[j-1] == '*' && flag[0][j-1]);
     *            = false: otherwise
     */
    /* DP: accept */
    public boolean isMatchDP2(String s, String p){
        int[] prev = new int[p.length() + 1];
        int[] cur = new int[p.length() + 1];
        // i = 0
        prev[0] = 1;
        for(int j = 1; j <= p.length(); j++){
            if(p.charAt(j-1) != '*')
                prev[j] = -1;
            else
                prev[j] = prev[j-1];
        }
        // DP
        for(int i = 1; i <= s.length(); i++){
            cur[0] = -1;
            for(int j = 1; j <= p.length(); j++){
                if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1))
                    cur[j] = prev[j-1];
                else if(p.charAt(j-1) == '*'){
                    if(cur[j-1] == 1 || prev[j] == 1)
                        cur[j] = 1;
                    else
                        cur[j] = -1;
                } else{
                    cur[j] = -1;
                }
            }
            System.arraycopy(cur, 0, prev, 0, p.length()+1);
        }
        return prev[p.length()] == 1;
    }

    /* DP: exceed memory limit */
    public boolean isMatchDP(String s, String p){
        int[][] match = new int[s.length()+1][p.length()+1];
        // initialize
        match[0][0] = 1;
        for(int i = 1; i <= s.length(); i ++)
            match[i][0] = -1;
        for(int j = 1; j <= p.length(); j ++){
            if(p.charAt(j-1) != '*')
                match[0][j] = -1;
            else
                match[0][j] = match[0][j-1];
        }
        return innerMatchDP(s, p, match, s.length(), p.length()) == 1;
    }

    public int innerMatchDP(String s, String p, int[][] match, int i, int j){
        if(match[i][j] == 0){
            if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)){
                match[i][j] = innerMatchDP(s, p, match, i-1, j-1);
            } else if(p.charAt(j-1) == '*'){
                if(innerMatchDP(s, p, match, i, j-1) == 1 ||
                    innerMatchDP(s, p, match, i-1, j) == 1){
                    match[i][j] = 1;
                } else{
                    match[i][j] = -1;
                }
            } else{
                match[i][j] = -1;
            }
        }
        return match[i][j];
    }
    public void print(int[][] match){
        for(int i = 0; i < match.length; i ++){
            for(int j = 0; j < match[0].length; j++){
                System.out.print(match[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* brute force: exceed time limit */
    public boolean isMatch(String s, String p){
        if(p.length() == 0)
            return s.length() == 0;
        if(p.charAt(0) == '*'){
            for(int i = 0; i <= s.length(); i ++){
                if(isMatch(s.substring(i), p.substring(1)))
                    return true;
            }
            return false;
        }
        if(s.length() == 0) return false;
        if(p.charAt(0) == '?' || p.charAt(0) == s.charAt(0))
            return isMatch(s.substring(1), p.substring(1));
        else
            return false;
    }
    public static void main(String[] argvs){
        WildcardMatching wm = new WildcardMatching();
        System.out.println(wm.isMatchGreedy("aa", "a"));
        System.out.println(wm.isMatchGreedy("aa", "aa"));
        System.out.println(wm.isMatchGreedy("aaa", "aa"));
        System.out.println(wm.isMatchGreedy("aa", "*"));
        System.out.println(wm.isMatchGreedy("aa", "a*"));
        System.out.println(wm.isMatchGreedy("aa", "?*"));
        System.out.println(wm.isMatchGreedy("aab", "c*a*b"));
    }
}