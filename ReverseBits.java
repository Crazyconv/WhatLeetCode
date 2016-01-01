// optimization when called multiple times: https://leetcode.com/discuss/74312/share-solution-optimize-when-this-function-called-many-times
public class ReverseBits{
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int helper = Integer.MIN_VALUE;
        int result = 0;
        while(helper != 0){
            result = (result << 1) | (n & 1);
            helper = helper >>> 1;
            n = n >> 1;
        }
        return result;
    }
    public static void main(String[] argvs){
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(1));
    }
}