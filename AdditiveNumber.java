public class AdditiveNumber{
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for(int i = 1; i < (len + 1) / 2; i++){
            for(int j = 1; Math.max(i, j) <= len - i - j; j++){
                if(isValid(i, j, num, len))
                    return true;
            }
        }
        return false;
    }    

    public boolean isValid(int i, int j, String num, int len){
        if(num.charAt(0) == '0' && i > 1)
            return false;
        if(num.charAt(i) == '0' && j > 1)
            return false;
        BigInteger n1 = new BigInteger(num.substring(0, i));
        BigInteger n2 = new BigInteger(num.substring(i, i + j));
        int nextPos = i + j;
        while(nextPos < len){
            n2 = n2.add(n1);
            String sum = n2.toString();
            if(num.startsWith(sum, nextPos)){
                n1 = n2.subtract(n1);
                nextPos += sum.length();
            } else {
                return false;
            }
        }
        return true;
    }
}