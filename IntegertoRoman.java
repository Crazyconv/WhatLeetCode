public class IntegertoRoman{
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] div = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for(int i = 0; i < 13 && num != 0; i++){
            while(num >= div[i]){
                sb.append(symbols[i]);
                num -= div[i];
            }
        }
        return sb.toString();
    }    
}