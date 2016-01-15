public class RomantoInteger{
    public int romanToInt(String s) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('M', 1000);
        m.put('D', 500);
        m.put('C', 100);
        m.put('L', 50);
        m.put('X', 10);
        m.put('V', 5);
        m.put('I', 1);
        int last = m.get(s.charAt(0));
        int num = last;
        for(int i = 1; i < s.length(); i++){
            int cur = m.get(s.charAt(i));
            num += cur;
            if(cur > last)
                num -= (last << 1);
            last = cur;
        }
        return num;
    }    
}