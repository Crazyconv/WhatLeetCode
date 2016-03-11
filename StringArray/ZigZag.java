public class ZigZag{
    public static void main(String[] argvs){
        ZigZag zz = new ZigZag();
        System.out.println(zz.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows){
        if(numRows <= 1){
            return s;
        }
        char[] r = new char[s.length()];
        int gap = 2 * (numRows - 1);
        int i = 0, j = 0;
        while(j < s.length()){
            r[i] = s.charAt(j);
            j += gap;
            i ++;
        }
        for(int k = 1; k < numRows - 1; k++){
            int dis1 = gap - 2 * k;
            int dis2 = gap - dis1;
            j = k;
            while(j < s.length()){
                r[i] = s.charAt(j);
                j += dis1;
                i ++;
                if(j < s.length()){
                    r[i] = s.charAt(j);
                    j += dis2;
                    i ++;
                }
            }
        }
        j = numRows - 1;
        while(j < s.length()){
            r[i] = s.charAt(j);
            j += gap;
            i ++;
        }
        return String.valueOf(r);
    }
}