import java.util.HashSet;
public class LongestRepeatedSubString{
    /**********************************************************************
     **                              Naive                               **
     **********************************************************************/
    // O(n^3)
    public void getLRS(String s){
        HashSet<String> set = new HashSet<String>();
        for(int length = s.length() - 1; length >= 1; length --){ // length
            for(int start = 0; start + length <= s.length(); start++){
                String sub = s.substring(start, start + length);
                if(set.contains(sub)){
                    System.out.println(sub + "\n");    
                    return;
                } else {
                    set.add(sub);
                }
            }
        }
        System.out.println("No repeated substring\n");
    }
    /**********************************************************************
     **                         Suffix Tree                              **
     **********************************************************************/
    // O(n)

    public static void main(String[] argvs){
        LongestRepeatedSubString lrs = new LongestRepeatedSubString();
        lrs.getLRS("GEEKSFORGEEKS$");
        lrs.getLRS("AAAAAAAAAA$"); 
        lrs.getLRS("ABCDEFG$"); 
        lrs.getLRS("ABABABA$"); 
        lrs.getLRS("ATCGATCGA$");  
        lrs.getLRS("banana$"); 
        lrs.getLRS("abcpqrabpqpq$");  
        lrs.getLRS("pqrpqpqabab$"); 
    }
}