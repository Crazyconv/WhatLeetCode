import java.util.HashMap;
public class MinimumWindowSubstring{
    public static void main(String[] argvs){
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println(mws.minWindow("bba", "ab"));
    }
    public void incr(HashMap<Character, Integer> m, Character c){
        Integer count = m.get(c);
        if(count != null){
            m.put(c, count + 1);
        } else {
            m.put(c, 1);
        }
    }
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length())
            return "";

        HashMap<Character, Integer> targetCount = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++){
            incr(targetCount, t.charAt(i));
        }
        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();

        int i = 0, j = 0;
        int minWindow = s.length() + 1;
        int tLen = t.length();
        int effectiveCount = 0;
        int start = -1, end = -1;
        while(j < s.length()){
            // move right pointer until targetCount is satisfied 
            while(j < s.length() && effectiveCount < tLen){
                Character c = s.charAt(j);
                if(targetCount.containsKey(c)){
                    incr(charCount, c);
                    if(charCount.get(c) <= targetCount.get(c)){
                        effectiveCount ++;
                    }
                }
                j++;
            }
            if(effectiveCount == tLen){
                // move left pointer until non-necessary characters are removed, because we want the minimum length
                while(true){
                    Character c = s.charAt(i);
                    if(targetCount.containsKey(c)){
                        if(charCount.get(c) <= targetCount.get(c))
                            break;
                        else{
                            charCount.put(c, charCount.get(c) - 1);
                        }
                    }
                    i++;
                }
                if(minWindow > j - i){
                    minWindow = j - i;
                    start = i;
                    end = j;
                }
            }
            if(j < s.length()){
                // move the left pointer until the target count is not satisfied
                while(i < j){
                    Character c = s.charAt(i);
                    if(charCount.containsKey(c)){
                        charCount.put(c, charCount.get(c) - 1);
                        if(charCount.get(c) < targetCount.get(c)){
                            effectiveCount --;
                            i++;
                            break;
                        }
                    }
                    i++;
                }
            }
        }
        if(start != -1)
            return s.substring(start, end);
        else 
            return "";
    }    
}