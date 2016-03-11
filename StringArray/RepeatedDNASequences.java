// optimization explanation: https://leetcode.com/discuss/74330/20-ms-solution-c-with-explanation
// 1. encode string(length 10) as integer(20 bits)
//    a. string comparison is expensive
//    b. make use of overlapping
// 2. use BitSet instead of HashSet
//    a. reduce Value memory: integer -> bit
//    b. reduce Key memory: do not need to store key, use index
import java.util.BitSet;
import java.util.ArrayList;
import java.util.List;
public class RepeatedDNASequences{
    public List<String> findRepeatedDnaSequences(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if(s.length() > 10){
            int[] charToInt = new int[26];
            charToInt['A' - 'A'] = 0;
            charToInt['C' - 'A'] = 1;
            charToInt['G' - 'A'] = 2;
            charToInt['T' - 'A'] = 3;

            BitSet s1 = new BitSet(1<<20);
            BitSet s2 = new BitSet(1<<20);

            int code = 0;
            int mask = (1 << 20) - 1;
            for(int i = 0; i < 10; i++){
                code = (code << 2) | charToInt[s.charAt(i) - 'A'];
            }
            s1.set(code);
            for(int i = 10; i < s.length(); i++){
                code = ((code << 2) & mask) | charToInt[s.charAt(i) - 'A'];
                if(!s2.get(code)){
                    if(s1.get(code)){
                        result.add(s.substring(i-9, i+1));
                        s2.set(code);
                    }
                    else
                        s1.set(code);
                }
            }
        }
        return result;
    }  
    public static void main(String[] argvs){
        RepeatedDNASequences rds = new RepeatedDNASequences();
        for(String s: rds.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")){
            System.out.println(s);
        }
    }  
}