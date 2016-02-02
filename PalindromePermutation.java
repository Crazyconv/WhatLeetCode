public class PalindromePermutation{
    public boolean canPermutePalindrome(String s) {
        boolean[] count = new boolean[256];
        for(int i = 0; i < s.length(); i++){
            count[(int)s.charAt(i)] = !count[(int)s.charAt(i)];
        }
        boolean odd = false;
        for(int i = 0; i < 256; i ++){
            if(count[i]){
                if(odd)
                    return false;
                else
                    odd = true;
            }
        }
        return true;
    }    
}