public class ShortestPalindrome{
    // find the longest palinrome prefix using KMP
    // O(n)
    public String shortestPalindrome(String s) {
        if(s == null || s.length() < 2){
            return s;
        } else {
            int maxPalPrefix = kmp(new StringBuilder(s).append("#").append(new StringBuilder(s).reverse()));
            return new StringBuilder().append(s.substring(maxPalPrefix)).reverse().append(s).toString();
        }
    }

    public int kmp(StringBuilder sb){
        int[] arr = new int[sb.length()];
        arr[0] = 0;
        int len = 0;
        int i = 1;
        while(i < sb.length()){
            if(sb.charAt(i) == sb.charAt(len)){
                arr[i] = ++len;
                i++;
            } else if(len > 0){
                len = arr[len-1];
            } else {
                arr[i] = 0;
                i++;
            }
        }
        return arr[i-1];
    }

    // another method O(n^2) but take care of long repeated characters
    public String shortestPalindrome(String s) {
        if(s == null || s.length() < 2){
            return s;
        } else {
            int maxPalPrefix = calculate(s.toCharArray());
            return new StringBuilder().append(s.substring(maxPalPrefix)).reverse().append(s).toString();
        }
    }

    public int calculate(char[] s){
        int maxLength = 0;
        int begin = 0;
        while(begin <= s.length / 2){
            int start, end;
            start = end = begin;
            while(end < s.length - 1 && s[end] == s[end + 1])
                end ++;
            begin = end + 1;

            while(start > 0 && end < s.length - 1 && s[start - 1] == s[end + 1]){
                start--;
                end++;
            }
            if(start == 0){
                int len = end - start + 1;
                if(len > maxLength)
                    maxLength = len;
            }
        }
        return maxLength;
    }
}