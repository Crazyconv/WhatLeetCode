public class LongestPalindromicSubstring{
    /**********************************************************************
     **                              Naive                               **
     **********************************************************************/
    // O(n^2)
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";
        int longest = 0, start = -1, end = -1;
        for(int i = 0; i < s.length()-1; i++){
            for(int j = 1; j <= 2 && i+j < s.length(); j ++){
                int n = i + j;
                int m = i;
                while(m >= 0 && n <= s.length() - 1){
                    if(s.charAt(m) != s.charAt(n))
                        break;
                    else{
                        m--; n++;
                    }
                }
                int length = n - m - 1;
                if(length > longest){
                    longest = length;
                    start = m + 1;
                    end = n - 1;
                }
            }
        }
        if(start == -1)
            return s.substring(0,1);
        else
            return s.substring(start, end+1);
    }

    /**********************************************************************
     **                      Dynamic Programming                         **
     **********************************************************************/
    // O(nm) 
    public String longestPalindromeDP(String s) {
        // i,i: true
        // i,i+1: true if s[i] == s[i+1]
        // i,j: true if s[i] == s[j] && value[i+1][j-1] is true
        if(s == null || s.length() == 0)
            return "";
        boolean[][] value = new boolean[s.length()][s.length()];
        int longest = 0, start = -1, end = -1;
        for(int i = s.length()-1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(j == i)
                    value[i][j] = true;
                else if(j == i+1)
                    value[i][j] = (s.charAt(i) == s.charAt(j));
                else
                    value[i][j] = (s.charAt(i) == s.charAt(j)) && (value[i+1][j-1]);
                if(value[i][j]){
                    int length = j-i+1;
                    if(length > longest){
                        longest = length;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        if(start == -1)
            return s.substring(0,1);
        else
            return s.substring(start, end+1);
    }  

    /**********************************************************************
     **                   Manacher's Algorithm                           **
     **********************************************************************/
    // O(n)
    // http://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-4/
    public String longestPalindromeManacher(String s){
        // s.length() >= 1
        // # Initialize #
        // positions: N = 2 * s.length() + 1
        // t[0] = 0, t[1] = 1
        // center = 1, centerRight = 2
        // longest = 1, longestPosition = 1
        // # shift #
        // for(current = 2; current < N; current ++):
        //     mirror = 2 * center - current
        //     diff = centerRight - current
        //     expand = false
        //     if diff > 0:
        //         if(t[mirror] < diff): t[current] = t[mirror]
        //         if(t[mirror] == diff && centerRight == N-1): t[current] = t[mirror]
        //         if(t[mirror] == diff && centerRight < N-1): t[current] = t[mirror], expand = true
        //         if(t[mirror] > diff): t[current] = diff, expand = true
        //     else:
        //         t[current] = 0, expand = true
        //     # expand if necessary
        //     if(expand): # if left/right is even, +1, if left/eight is odd and left = eight, +1
        //         while(
        //               (current-t[current] > 0 && current+t[current] < N-1) &&
        //               (
        //                (current-t[current]-1)%2 == 0) ||
        //                (s[(current-t[current]-1)/2] == s[(current+t[current]+1)/2])
        //               )
        //              ):
        //             t[current] ++;
        //     # update max #
        //     if(t[current] > longest): longest = t[current], longestPosition = current
        //     # update center #
        //     if(centerRight < current + t[current]): center = current, centerRight = current + t[current]
        // # calculate palindrome
        // s.substring((longestPosition-longest)/2, (longestPosition+longest+1)/2)
        if(s == null || s.length() == 0)
            return "";
        int N = s.length() * 2 + 1;
        int[] t = new int[N];
        t[0] = 0; t[1] = 1;
        int center = 1, centerRight = 2;
        int longest = 1, longestPosition = 1;
        for(int current = 2; current < N; current++){
            int mirror = 2 * center - current;
            int diff = centerRight - current;
            boolean toExpand = false;
            if(diff > 0){
                if(t[mirror] < diff){
                    t[current] = t[mirror];
                } else if(t[mirror] == diff && centerRight == N - 1){
                    t[current] = t[mirror];
                } else if(t[mirror] == diff && centerRight < N - 1){
                    t[current] = t[mirror];
                    toExpand = true;
                } else if(t[mirror] > diff){
                    t[current] = diff;
                    toExpand = true;
                }
            } else {
                t[current] = 0;
                toExpand = true;
            }
            if(toExpand){
                while((current - t[current] > 0 && current + t[current] < N - 1) && 
                      ((current-t[current]-1)%2 == 0 ||
                       s.charAt((current-t[current]-1)/2) == s.charAt((current+t[current]+1)/2))
                     ){
                    t[current] ++;
                }
            }
            if(t[current] > longest){
                longest = t[current];
                longestPosition = current;
            }
            if(centerRight < current + t[current]){
                center = current;
                centerRight = current + t[current];
            }
        }
        return s.substring((longestPosition-longest)/2, (longestPosition+longest+1)/2);
    }

    /**********************************************************************
     **                           Suffix tree                            **
     **********************************************************************/
    // O(n)
    // see https://github.com/Crazyconv/WhatLeetCode/blob/master/template/ApplicationsOfSuffixTree/LongestPalindromicSubstring.java

    public static void main(String[] argvs){
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.longestPalindromeManacher("abbac"));
    }
}