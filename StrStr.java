// KMP algorithm:
// http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/

public class StrStr{
    public int[] longestPreSuffix(String needle){
        // assume needle is not null, nor empty
        int[] table = new int[needle.length()];
        table[0] = 0;
        for(int i = 1; i < needle.length(); i++){
            int index = table[i-1];
            while(needle.charAt(index) != needle.charAt(i) && index > 0){
                index = table[index - 1];
            }
            if(needle.charAt(index) == needle.charAt(i)){
                table[i] = index + 1;
            }else{
                table[i] = 0;
            }
        }
        return table;
    }
    public int maxMatch(String haystack, int i, String needle, int preMatched){
        int j = preMatched;
        i += preMatched;
        while(i < haystack.length() && j < needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            } else {
                return j;
            }
        }
        return j;
    }
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() == 0)
            return 0;
        int hLen = haystack.length();
        int nLen = needle.length();
        if(hLen < nLen)
            return -1;

        // construct table
        int[] table = longestPreSuffix(needle);

        // start from i = 0, matched = 0
        // if(hay.length - i < ne.length) return -1
        // n = longestmatch(hay, i, ne, matched)
        // if(n == ne.length) return 1
        // if n = 0 i++
        // matched = table[n-1]
        // i += (n - matched)
        int i = 0, preMatched = 0;
        while(true){
            if(hLen - i < nLen)
                return -1;
            int numMatched = maxMatch(haystack, i, needle, preMatched);
            if(numMatched == 0){
                i++;
            } else if (numMatched == nLen){
                return i;
            } else {
                preMatched = table[numMatched - 1];
                i += (numMatched - preMatched);
            }
        }
    }

    public static void main(String[] argvs){
        StrStr s = new StrStr();
        System.out.println(s.strStr("bacbababaabcbab", "ababa"));
        for(int i: s.longestPreSuffix("xybxyaxybxyb")){
            System.out.print(i + " ");
        }
        System.out.println();
    }  
}