public class AddBinary{
    public String addBinary(String a, String b){
        if(a == null || a.length() == 0)
            return b;
        if(b == null || b.length() == 0)
            return a;

        StringBuilder sb = new StringBuilder();
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int flag = 0;
        while(pa >= 0 || pb >= 0){
            int ca = 0, cb = 0;
            if(pa >= 0){
                ca = a.charAt(pa) - '0';
                pa --;
            }
            if(pb >= 0){
                cb = b.charAt(pb) - '0';
                pb --;
            }
            int sum = ca + cb + flag;
            if(sum >= 2){
                flag = 1;
                sb.append((sum-2 == 1)? '1':'0');
            }else{
                flag = 0;
                sb.append((sum == 1)? '1':'0');
            }
        }
        if(flag == 1)
            sb.append('1');
        return sb.reverse().toString();
    }
    // public String addBinary(String a, String b){
    //     if(a.length() > b.length()){
    //         return add(a, b);
    //     } else {
    //         return add(b, a);
    //     }
    // }
    // public String add(String l, String s){
    //     int i, a, b, c = 0;
    //     int endL = l.length() - 1, endS = s.length() - 1;
    //     char[] result = new char[endL + 2];

    //     for(i = 0; i <= endS; i++){
    //         a = l.charAt(endL - i) - '0';
    //         b = s.charAt(endS - i) - '0';
    //         result[endL + 1 - i] = ((a ^ b ^ c) == 1)? '1' : '0';
    //         c = (a & b) | (a & c) | (b & c);
    //     }
    //     while(i <= endL){
    //         a = l.charAt(endL - i) - '0';
    //         result[endL + 1 - i] = ((a ^ c) == 1)? '1' : '0';
    //         c = a & c;
    //         i++;
    //     }
    //     result[0] = (c == 1)? '1' : '0';
    //     if(result[0] == '0')
    //         return String.valueOf(result, 1, endL + 1);
    //     else
    //         return String.valueOf(result);
    // }
    public static void main(String[] argvs){
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("11", "1"));
    }
}