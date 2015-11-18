public class SearchPattern{
    // assume s is at least as long as p and p is not empty

    /**********************************************************************
     **                              Naive                               **
     **********************************************************************/
    // O(nm)
    public void naiveSearch(String s, String p){
        int sLen = s.length(), pLen = p.length();
        for(int i = 0; i <= sLen - pLen; i++){
            boolean found = true;
            for(int j = 0; j < pLen; j++){
                if(s.charAt(i+j) != p.charAt(j)){
                    found = false;
                    break;
                }
            }
            if(found)
                System.out.println("Found pattern at index " + String.valueOf(i));
        }
    }

    /**********************************************************************
     **                                KMP                               **
     **********************************************************************/
    // O(n)
    public int[] computeLPSArray(String s){
        int[] lps = new int[s.length()];
        int len = 0; // length of the previous longest prefix suffix
        lps[0] = 0;
        int i = 1;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            } else if (len == 0){
                lps[i] = 0;
                i++;
            } else {
                len = lps[len-1];
            }
        }
        return lps;
    }
    public void KMPSearch(String s, String p){
        int[] lps = computeLPSArray(p);
        int i = 0, j = 0;
        int sLen = s.length(), pLen = p.length();
        while(sLen - i >= pLen - j && pLen - j > 0){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
                if(j == pLen){
                    System.out.println("Found pattern at index " + String.valueOf(i-j));
                    j = lps[j-1];
                }
            } else if (j==0){
                i++;
            } else {
                j = lps[j-1];
            }
        }
    }

    /**********************************************************************
     **                           Rabin-Karp                             **
     **********************************************************************/
    // average/best: O(m+n); worst: O(mn)
    public void RabinKarpSearch(String s, String p){
        int prime = 101, d = 256;
        int hashS = 0, hashP = 0, msb = 1;
        int sLen = s.length(), pLen = p.length();
        for(int i = 0; i < pLen - 1; i++){
            msb = (msb * d) % prime;
        }
        for(int i = 0; i < pLen; i++){
            hashS = (hashS * d + s.charAt(i)) % prime;
            hashP = (hashP * d + p.charAt(i)) % prime;
        }
        for(int i = 0; i <= sLen - pLen; i++){
            if(hashS == hashP){
                int j = 0;
                for(j = 0; j < pLen; j++){
                    if(s.charAt(i + j) != p.charAt(j)){
                        break;
                    }
                }
                if(j == pLen){
                    System.out.println("Found pattern at index " + String.valueOf(i));
                }
            }
            if(i != sLen - pLen){
                hashS = ((hashS - msb * s.charAt(i)) * d + s.charAt(i+pLen)) % prime;
                if(hashS < 0)
                    hashS += prime;
            }
        }
    }

    public static void main(String[] args){
        SearchPattern sp = new SearchPattern();
        // sp.KMPSearch("hellyhelloxy", "hello");
        // sp.RabinKarpSearch("hellyhelloxyhello", "hello");
        sp.naiveSearch("hellyhelloxyhello", "hello");
    }
}