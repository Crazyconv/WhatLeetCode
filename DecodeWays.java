public class DecodeWays{
    public int numDecodings(String s) {
        if(s.length() == 0)
            return 0;
        int[] result = new int[s.length()+1];
        result[0] = 1;
        result[1] = (s.charAt(0) == '0')? 0 : 1;
        for(int i = 2; i < result.length; i ++){
            if(s.charAt(i-1) != '0')
                result[i] += result[i-1];
            if(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6'))
                result[i] += result[i-2];
        }
        return result[s.length()];
    }    
}