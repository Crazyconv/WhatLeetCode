public class ValidAnagram{
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[(int) s.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < t.length(); i ++){
            if(--count[(int) t.charAt(i) - 'a'] < 0)
                return false;
        }
        for(int i = 0; i < 26; i ++){
            if(count[i] != 0)
                return false;
        }
        return true;
    }    
}