import java.util.Arrays;
import java.util.Comparator;
public class SuffixArray{
    /**********************************************************************
     **                              Naive                               **
     **********************************************************************/
    // O(n^2lgn)
    public int[] naiveBuild(String s){
        Suffix[] array = new Suffix[s.length()];
        for(int i = 0; i < s.length(); i++){
            array[i] = new Suffix(i, s.substring(i));
        }

        Arrays.sort(array, new Comparator<Suffix>(){
            public int compare(Suffix s1, Suffix s2){
                return s1.s.compareTo(s2.s);
            }
        });

        int[] indexArray = new int[s.length()];
        for(int i = 0; i < s.length(); i ++){
            indexArray[i] = array[i].index;
        }
        return indexArray;
    }

    /**********************************************************************
     **                           Unknown                                **
     **********************************************************************/
    // O(nlgnlgn)
    // sort the suffix array based on the first 2 characters, then 4, 8, ...
    // http://www.geeksforgeeks.org/suffix-array-set-2-a-nlognlogn-algorithm/
    public int[] improvedBuild(String s){
        RankSuffix[] array = new RankSuffix[s.length()];
        for(int i = 0; i < s.length(); i++){
            array[i] = new RankSuffix(i, s.substring(i));
        }
        Arrays.sort(array); // array is sorted based on first 2 characters
        for(int k = 4; k < 2 * s.length(); k *= 2){
            // update ranks[0]
            int[] ind = new int[s.length()];
            int rank = 0;
            int preRank = array[0].ranks[0];
            array[0].ranks[0] = rank;
            for(int i = 1; i < array.length; i++){
                if(array[i].ranks[0] == preRank && 
                    array[i].ranks[1] == array[i-1].ranks[1]){
                    array[i].ranks[0] = rank;
                } else {
                    rank ++;
                    array[i].ranks[0] = rank;
                }
                ind[array[i].index] = i;
            }

            // update ranks[1]
            for(int i = 1; i < array.length; i++){
                array[i].ranks[1] = (array[i].index + k/2 >= s.length())? -1 : 
                    array[ind[array[i].index + k/2]].ranks[0];
            }

            Arrays.sort(array);
            // at this point, array is sorted based on first k characters.
        }

        int[] indexArray = new int[s.length()];
        for(int i = 0; i < s.length(); i ++){
            indexArray[i] = array[i].index;
        }
        return indexArray;
    }

    /**********************************************************************
     **                          Suffix Tree                             **
     **********************************************************************/

    public static void main(String[] argvs){
        SuffixArray sa = new SuffixArray();
        // int[] result = sa.naiveBuild("banana");
        int[] result = sa.improvedBuild("banana");
        for(int i = 0; i < result.length; i++){
            System.out.print(String.valueOf(result[i]) + " ");
        }
    }
}
class Suffix{
    int index;
    String s;
    public Suffix(int index, String s){
        this.index = index;
        this.s = s;
    }
}
class RankSuffix implements Comparable<RankSuffix>{
    int index;
    String s;
    int[] ranks;
    public RankSuffix(int index, String s){
        this.index = index;
        this.s = s;
        this.ranks = new int[2];
        this.ranks[0] = s.charAt(0) - 'a';
        this.ranks[1] = (s.length() >= 2)? s.charAt(1) - 'a' : -1;
    }
    public int compareTo(RankSuffix r){
        if(this.ranks[0] < r.ranks[0])
            return -1;
        else if(this.ranks[0] > r.ranks[0])
            return 1;
        else if(this.ranks[1] < r.ranks[1])
            return -1;
        else if(this.ranks[1] > r.ranks[1])
            return 1;
        else
            return 0;
    }
}