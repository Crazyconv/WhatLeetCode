public class BitwiseANDOfNumbersRange{
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        for(int i = 30; i >= 0; i --){
            if((m & (1 << i)) != 0)
                result |= (1 << i);
            else if((n & (1 << i)) != 0)
                return result;
        }
        return result;
    }    
}