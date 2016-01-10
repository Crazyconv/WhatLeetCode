import java.util.HashMap;
public class FractionToRecurringDecimal{
    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorL = (long) numerator;
        long denominatorL = (long) denominator;
        if(numeratorL % denominatorL == 0)
            return String.valueOf(numeratorL/denominatorL);

        boolean negative = false;
        if(numeratorL < 0){
            negative = !negative;
            numeratorL = 0 - numeratorL;
        }
        if(denominatorL < 0){
            negative = !negative;
            denominatorL = 0 - denominatorL;
        }
        long integer = numeratorL / denominatorL;
        long remainer = numeratorL - (integer * denominatorL);

        StringBuilder sb = new StringBuilder();
        if(negative)
            sb.append('-');
        sb.append(integer);
        sb.append('.');
        int nextIndex = sb.length();

        HashMap<Long, Integer> m = new HashMap<Long, Integer>();
        m.put(remainer, nextIndex);
        while(remainer != 0){
            integer = remainer * 10 / denominatorL;
            remainer = remainer * 10 - denominatorL * integer;
            sb.append(integer);

            Integer repeat = m.get(remainer);
            if(repeat != null){
                sb.insert(repeat, "(");
                sb.append(")");
                break;
            }
            m.put(remainer, ++nextIndex);
        }
        return sb.toString();
    }    
    public static void main(String[] argvs){
        FractionToRecurringDecimal ftd = new FractionToRecurringDecimal();
        System.out.println(ftd.fractionToDecimal(-1, -2147483648));
    }
}