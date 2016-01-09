public class PalindromeNumber{
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int digitNum = 1;
        int tempX = x;
        while(tempX > 9){
            digitNum *= 10;
            tempX /= 10;
        }
        int h = 0, l = 0;
        while(x != 0){
            h = x / digitNum;
            l = x % 10;
            if(h != l)
                return false;
            x = (x - digitNum * h) / 10;
            digitNum /= 100;
        }
        return true;
    }    
}