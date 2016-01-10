public class HappyNumber{
    public boolean isHappy(int n) {
        HashSet<Integer> s = new HashSet<Integer>();
        s.add(n);
        while(true){
            int temp = 0;
            while(n != 0){
                temp += (n%10) * (n%10);
                n /= 10;
            }
            if(temp == 1)
                return true;
            if(s.contains(temp))
                return false;
            s.add(temp);
            n = temp;
        }
    }    
}