//https://leetcode.com/discuss/78532/summary-all-solutions-new-method-included-at-15-30pm-jan-8th
public class PowerOfThree{
    public boolean isPowerOfThree(int n) {
        int max = (int)Math.pow(3, (int)(Math.log(Integer.MAX_VALUE) / Math.log(3)));
        return n > 0 && max % n == 0;
    }
}