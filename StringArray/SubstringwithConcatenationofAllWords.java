import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.HashMap;
public class SubstringwithConcatenationofAllWords{
    public static void main(String[] argvs){
        SubstringwithConcatenationofAllWords sca = new SubstringwithConcatenationofAllWords();
        String[] words = {"word","good","best"};
        String s = "wordgoodgoodgoodbestword";
        ArrayList<Integer> result = (ArrayList) sca.findSubstring(s, words);
        for(Integer i: result){
            System.out.println(String.valueOf(i));
        }
    }
    public void incr(HashMap<String, Integer> m, String key){
        Integer i = m.get(key);
        if(i == null)
            m.put(key, 1);
        else
            m.put(key, i+1);
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || words == null || words.length == 0)
            return results;

        HashMap<String, Integer> wordSet = new HashMap<String, Integer>();
        for(String word: words){
            incr(wordSet, word);
        }

        int wordCount = words.length;
        int wordLen = words[0].length();
        // can start from 0... wordLen-1, for each, jumps wordLen every time
        for(int i = 0; i < wordLen; i++){
            int j = i, k = i;
            HashMap<String, Integer> nonRepeated = new HashMap<String, Integer>();
            int acturalCount = 0;
            // move the right pointer until the next word is not in words, or the next word causes exceeded count
            while(k + wordLen <= s.length()){
                boolean notIn = false;
                String sub = null;
                while(k + wordLen <= s.length()){
                    sub = s.substring(k, k + wordLen);
                    if(!wordSet.containsKey(sub)){
                        notIn = true;
                        break;
                    } else if (wordSet.get(sub) == nonRepeated.get(sub)){
                        break;
                    } else {
                        acturalCount ++;
                        incr(nonRepeated, sub);
                        k += wordLen;
                    }
                }
                // need to check whether satisfied
                if(acturalCount == wordCount)
                    results.add(j);
                // if not contained, reset
                if(notIn){
                    k += wordLen;
                    j = k;
                    nonRepeated = new HashMap<String, Integer>();
                    acturalCount = 0;
                } else if(k + wordLen <= s.length()){
                    // move left pointer until the exceeded word is removed.
                    while(j < k){
                        String temp = s.substring(j, j + wordLen);
                        nonRepeated.put(temp, nonRepeated.get(temp) - 1);
                        acturalCount --;
                        j += wordLen;
                        if(temp.equals(sub))
                            break;
                    }
                }
            }
        }
        return results;
    }    
}