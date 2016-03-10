import java.util.*;
public class NQueens{
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        int[] item = new int[n];
        Arrays.fill(item, -1);
        solve(0, n, item, result);
        return result;
    }    
    public void solve(int pos, int n, int[] item, ArrayList<List<String>> result){
        if(pos == n){
            ArrayList<String> arr = new ArrayList<String>(n);
            for(int i = 0; i < n; i++){
                char[] line = new char[n];
                Arrays.fill(line, '.');
                line[item[i]] = 'Q';
                arr.add(new String(line));
            }
            result.add(arr);
        } else {
            for(int i = 0; i < n; i++){
                if(isValid(item, i, pos)){
                    item[i] = pos;
                    solve(pos + 1, n, item, result);
                    item[i] = -1;
                }
            }
        }
    }

    public boolean isValid(int[] item, int row, int col){
        if(item[row] != -1)
            return false;

        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i --, j--){
            if(item[i] == j)
                return false;
        }
        for(int i = row + 1, j = col + 1; i < item.length && j < item.length; i++, j++){
            if(item[i] == j)
                return false;
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < item.length; i --, j++){
            if(item[i] == j)
                return false;
        }
        for(int i = row + 1, j = col - 1; i < item.length && j >= 0; i++, j--){
            if(item[i] == j)
                return false;
        }
        return true;
    }

    // use boolean vector
    public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        int[] item = new int[n];
        boolean[] dia1 = new boolean[2 * n - 1];
        boolean[] dia2 = new boolean[2 * n - 1];
        Arrays.fill(item, -1);
        solve(0, n, item, result);
        return result;
    }    
    public void solve(int pos, int n, int[] item, boolean[] dia1, boolean[] dia2, ArrayList<List<String>> result){
        if(pos == n){
            ArrayList<String> arr = new ArrayList<String>(n);
            for(int i = 0; i < n; i++){
                char[] line = new char[n];
                Arrays.fill(line, '.');
                line[item[i]] = 'Q';
                arr.add(new String(line));
            }
            result.add(arr);
        } else {
            for(int i = 0; i < n; i++){
                if(item[i] == -1 && !dia1[i + pos] && !dia2[n - 1 - pos + i]){
                    item[i] = pos;
                    dia1[i + pos] = true;
                    dia2[n - 1 - pos + i] = true;
                    solve(pos + 1, n, item, dia1, dia2, result);
                    item[i] = -1;
                    dia1[i + pos] = false;
                    dia2[n - 1 - pos + i] = false;
                }
            }
        }
    }
    public static void main(String[] argvs){
        NQueens nq = new NQueens();
        for(List<String> l : nq.solveNQueens(4)){
            for(String s : l){
                System.out.println(s);
            }
            System.out.println();
        }
    }
}