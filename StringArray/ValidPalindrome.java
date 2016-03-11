public class ValidPalindrome{
    public static void main(String[] agvs){
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("0 man, a plan, a canal: Panam0"));
        System.out.println(vp.isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s){
        if(s.length() > 0){
            int i = 0, j = s.length() - 1;
            while(i < j){
                while(!(Character.isDigit(s.charAt(i)) || Character.isAlphabetic(s.charAt(i))) && i < j){
                    i ++;
                }
                while(!(Character.isDigit(s.charAt(j)) || Character.isAlphabetic(s.charAt(j))) && i < j){
                    j --;
                }
                if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
                    i ++;
                    j --;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}