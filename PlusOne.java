public class PlusOne{
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0 && carry != 0; i--){
            int num = digits[i] + carry;
            if(num >= 10){
                carry = 1;
                digits[i] = num - 10;
            } else {
                carry = 0;
                digits[i] = num;
            }
        }
        if(carry != 1){
            return digits;
        } else {
            int[] realResult = new int[digits.length + 1];
            realResult[0] = 1;
            System.arraycopy(digits, 0, realResult, 1, digits.length);
            return realResult;
        }
    }    
}