public class CountAndSay{
    public String countAndSay(int n) {
        String pre = "1";
        while(n > 1){
            pre = transform(pre);
            n--;
        }
        return pre;
    }
    public String transform(String s){
        char c = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == c){
                count ++;
            } else {
                sb.append(count);
                sb.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}