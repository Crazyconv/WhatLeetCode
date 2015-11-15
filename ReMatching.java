public class ReMatching{
    public static void main(String[] argvs){
        ReMatching wm = new ReMatching();
        System.out.println(wm.isMatchDP("aa", "a"));
        System.out.println(wm.isMatchDP("aa", "aa"));
        System.out.println(wm.isMatchDP("aaa", "aa"));
        System.out.println(wm.isMatchDP("aa", "a*"));
        System.out.println(wm.isMatchDP("aa", ".*"));
        System.out.println(wm.isMatchDP("ab", ".*"));
        System.out.println(wm.isMatchDP("aab", "c*a*b"));
    }
    public boolean isMatchDP(String s, String p){
        // res[i][j] represents whether the first i character of s matches the first j character of p
        // res[s.length()+1][p.length()+1]
        // res[0][0] = true
        // res[i+1][0] = false
        // res[0][j+1] = (p.charAt(j) == '*') && (j>=1) && (res[0][j-1])
        // res[i+1][j+1]:
        //     if(p[j] != '*') res[i+1][j+1] = res[i][j] && (p[j] == '.' || p[j] == s[i])
        //     else
        //         1.'?*' matches no character: j>=1 && res[i+1][j-1]
        //         2.'?*' matches one character: j>=1 && res[i][j-1] && (p[j-1] == '.' || s[i] == p[j-1])
        //         3.'?*' matches more than one character: res[i][j+1] && j>=1 && (p[j-1] == '.' || s[i] == p[j-1])
        if(p.length() == 0)
            return s.length() == 0;
        if(p.length() == 1)
            return (s.length() == 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)));

        boolean[][] res = new boolean[s.length()+1][p.length()+1];
        res[0][0] = true;
        for(int i = 0; i < s.length(); i++)
            res[i+1][0] = false;
        for(int j = 0; j < p.length(); j++)
            res[0][j+1] = (p.charAt(j) == '*') && (j>=1) && (res[0][j-1]);

        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                if(p.charAt(j) != '*'){
                    res[i+1][j+1] = res[i][j] && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i));
                } else {
                    res[i+1][j+1] = (j>=1 && res[i+1][j-1]) ||
                        (j>=1 && res[i][j-1] && (p.charAt(j-1) == '.' || s.charAt(i) == p.charAt(j-1))) ||
                        (res[i][j+1] && j>=1 && (p.charAt(j-1) == '.' || s.charAt(i) == p.charAt(j-1)));
                }
            }
        }
        return res[s.length()][p.length()];
    }
    public boolean isMatch(String s, String p){
        // if p.length == 0
        // if s.length == 0 return true, else return false
        // if p.length == 1
        // if s.length != 1 or (p[0] != '?' && s[0] != p[0]) return false, else return true 
        // if p[1] == "*"
        // if p[0] == '?'
        // for 0 - s.length(); if (s[0, ], p[2, ]) return true
        // return false;
        // if p[0] != '?'
        // for 0 - s.length(); if(not 0)
        // if p[1] != "*"
        // if p[0] != '?' && s[0] != p[0] return false, else return (s[1,], p[1, ])
        if(p.length() == 0)
            return s.length() == 0;
        if(p.length() == 1)
            return (s.length() == 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)));
        if(p.charAt(1) == '*'){
            if(p.charAt(0) == '.'){
                for(int i = 0; i <= s.length(); i++){
                    if(isMatch(s.substring(i), p.substring(2)))
                        return true;
                }
                return false;
            } else {
                for(int i = 0; i <= s.length(); i++){
                    if(i != 0 && s.charAt(i-1) != p.charAt(0))
                        return false;
                    if(isMatch(s.substring(i), p.substring(2)))
                        return true;
                }
                return false;
            }
        } else {
            if(s.length() == 0)
                return false;
            if(p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))
                return false;
            else
                return isMatch(s.substring(1), p.substring(1));
        }
    }    
}