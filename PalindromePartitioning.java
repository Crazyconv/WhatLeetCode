import java.util.*;
public class PalindromePartitioning{
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0)
            return new ArrayList<List<String>>();
        HashMap<Integer, ArrayList<List<String>>> m = new HashMap<Integer, ArrayList<List<String>>>();
        boolean[][] dp = buildTable(s);
        return partition(s, 0, m, dp);
    }  
    public ArrayList<List<String>> partition(String s, int pos, HashMap<Integer, ArrayList<List<String>>> m, boolean[][] dp) {
        ArrayList<List<String>> parts = m.get(pos);
        if(parts == null){
            parts = new ArrayList<List<String>>();
            for(int i = pos; i < s.length(); i++){
                if(dp[pos][i]){
                    String front = s.substring(pos, i + 1);
                    if(i == s.length() - 1){
                        ArrayList<String> item = new ArrayList<String>();
                        item.add(front);
                        parts.add(item);
                    } else {
                        ArrayList<List<String>> tails = partition(s, i + 1, m, dp);
                        for(List<String> tail : tails){
                            ArrayList<String> item = new ArrayList<String>();
                            item.add(front);
                            item.addAll(tail);
                            parts.add(item);
                        }
                    }
                }
            }
            m.put(pos, parts);
        }
        return parts;
    }
    public boolean[][] buildTable(String s){
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(j == i)
                    dp[i][j] = true;
                else if(j == i + 1)
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                else
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
            }
        }
        return dp;
    }
    public static void main(String[] argvs){
        PalindromePartitioning pp = new PalindromePartitioning();
        for(List<String> l: pp.partition("aabbcc")){
            for(String s : l){
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}