public class ReMatching{
    public static void main(String[] argvs){
        ReMatching wm = new ReMatching();
        System.out.println(wm.isMatch("a", ".*..a*"));
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