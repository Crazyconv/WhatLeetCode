public class Atoi{
    public static void main(String[] argvs){
        Atoi a = new Atoi();
        System.out.println(a.myAtoi("   -11ab"));
        System.out.println(a.myAtoi("   +11ab"));
        System.out.println(a.myAtoi("   11ab"));
        System.out.println(a.myAtoi("   011ab"));
        System.out.println(a.myAtoi("   ab"));
        System.out.println(a.myAtoi("   2147483647ab"));
        System.out.println(a.myAtoi("   +2147483648ab"));
        System.out.println(a.myAtoi("   -2147483648ab"));
    }

    public int myAtoi(String str){
        if(str == null)
            return 0;

        boolean neg = false;
        int num = 0, d = 0;
        int i = 0;
        int INT_MAX = 2147483647, INT_MIN = -2147483648;

        str = str.trim();
        if(str.length() < 1) return 0;
        if(str.charAt(i) == '+'){
            i++;
        } else if (str.charAt(i) == '-'){
            i++;
            neg = true;
        }

        while(i < str.length()){
            if(str.charAt(i) < '0' || str.charAt(i) > '9')
                return (neg)? 0-num : num;
            else{
                d = str.charAt(i) - '0';
                if(num > 214748364 ||
                    (num == 214748364 && neg && d == 9) ||
                    (num == 214748364 && !neg && d >= 8))
                    return (neg)? INT_MIN : INT_MAX;
                else
                    num = num * 10 + d;
            }
            i++;
        }
        return (neg)? 0-num : num;
    }
}