public class PermutationSequence{
    public String getPermutation(int n, int k) {
        int div = 1;
        for(int i = 2; i <= n; i++){
            div *= i;
        }
        if(k > div)
            return null;

        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            nums.add(i);
        }
        char[] ret = new char[n];
        k --;

        for(int i = 0; i < n; i++){
            div /= (n - i);
            int temp = (k / div) % n;
            k = k % div;
            ret[i] = (char)(nums.get(temp) + '0');
            nums.remove(temp);
        }
        return new String(ret);
    }   
}