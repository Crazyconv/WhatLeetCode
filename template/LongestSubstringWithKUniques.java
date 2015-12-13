import java.util.HashMap;
public class LongestSubstringWithKUniques{
    public void getLSK(String s, int k){
        int longest = 0, startIndex = 0;
        int start = 0, end = 0;
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        for(end = 0; end < s.length(); end++){
            incr(m, s.charAt(end));
            while(m.keySet().size() > k){
                decr(m, s.charAt(start));
                start ++;
            }
            if(m.keySet().size() == k && end - start + 1 > longest){
                longest = end - start + 1;
                startIndex = start;
            }
        }
        if(longest == 0){
            System.out.println("No LSK");
        } else {
            System.out.printf("LSK[%d]: %s\n", longest, s.substring(startIndex, startIndex+longest));
        }
    }
    private void incr(HashMap<Character, Integer> m, char c){
        Integer count = m.get(c);
        if(count == null)
            m.put(c, 1);
        else
            m.put(c, count+1);
    }
    private void decr(HashMap<Character, Integer> m, char c){
        Integer count = m.get(c);
        if(count == 1)
            m.remove(c);
        else
            m.put(c, count - 1);
    }
    public static void main(String[] argvs){
        LongestSubstringWithKUniques lsk = new LongestSubstringWithKUniques();
        lsk.getLSK("aabbcc", 1);
        lsk.getLSK("aabbcc", 2);
        lsk.getLSK("aabbcc", 3);
        lsk.getLSK("aaabbb", 3);
    }
}