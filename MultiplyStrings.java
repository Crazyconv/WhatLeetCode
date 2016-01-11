public class MultiplyStrings{
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
            return "";
        int[] result = new int[num1.length() + num2.length()];
        for(int i = 0; i < num1.length(); i++){
            for(int j = 0; j < num2.length(); j++){
                result[i+j+1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for(int i = result.length - 1; i > 0; i--){
            result[i-1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        StringBuilder sb = new StringBuilder();
        boolean nonzero = false;
        for(int i = 0; i < result.length - 1; i++){
            if(result[i] != 0){
                nonzero = true;
                sb.append(result[i]);
            } else if(nonzero){
                sb.append(result[i]);
            }
        }
        sb.append(result[result.length-1]);
        return sb.toString();
    }
}