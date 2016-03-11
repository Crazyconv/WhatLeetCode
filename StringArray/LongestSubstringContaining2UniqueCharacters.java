public class LongestSubstringContaining2UniqueCharacters{
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0, j = 0, maxLen = 0;
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        while(j < s.length()){
            // move right pointer until 2 keys already and the next character needs one more key
            while(j < s.length()){
                if(h.containsKey(s.charAt(j))){
                    h.put(s.charAt(j), h.get(s.charAt(j))+1);
                    j++;
                } else if(h.keySet().size() < 2){
                    h.put(s.charAt(j), 1);
                    j++;
                } else {
                    break;
                }
            }
            int len = j - i;
            if(maxLen < len)
                maxLen = len;
            if(j < s.length()){
                // move left pointer until one key is moved
                while(h.keySet().size() >= 2){
                    int count = h.get(s.charAt(i));
                    if(count == 1){
                        h.remove(s.charAt(i));
                        i++;
                        break;
                    } else {
                        h.put(s.charAt(i), count - 1);
                        i++;
                    }
                }
            }
        }
        return maxLen;        
    }   
}