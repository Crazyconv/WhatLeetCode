public class ReverseInteger{
    public int reverse(int x) {
        int rx = 0;
        int maxFirst = 0, maxSecond = 0; 
        if(x > 0){
            maxFirst = Integer.MAX_VALUE / 10;
            maxSecond = Integer.MAX_VALUE % 10;
        } else if (x < 0){
            maxFirst = Integer.MIN_VALUE / 10;
            maxSecond = Integer.MIN_VALUE % 10;
        }
        while(x != 0){
            if(x > 0){
                if(rx > maxFirst || rx == maxFirst && x%10 > maxSecond)
                    return 0;
            } else {
                if(rx < maxFirst || rx == maxFirst && x%10 < maxSecond)
                    return 0;
            }
            rx = rx * 10 + x % 10;
            x = x/10;
            System.out.println(rx);
        }
        return rx;
    }
}