public class NQueensII{
	int result = 0;
    public int totalNQueens(int n) {
    	result = 0;
        int[] item = new int[n];
        boolean[] dia1 = new boolean[2 * n - 1];
        boolean[] dia2 = new boolean[2 * n - 1];
        Arrays.fill(item, -1);
        solve(0, n, item, dia1, dia2);
        return result;
    }    
    public void solve(int pos, int n, int[] item, boolean[] dia1, boolean[] dia2){
        if(pos == n){
        	result ++;
        } else {
            for(int i = 0; i < n; i++){
                if(item[i] == -1 && !dia1[i + pos] && !dia2[n - 1 - pos + i]){
                    item[i] = pos;
                    dia1[i + pos] = true;
                    dia2[n - 1 - pos + i] = true;
                    solve(pos + 1, n, item, dia1, dia2);
                    item[i] = -1;
                    dia1[i + pos] = false;
                    dia2[n - 1 - pos + i] = false;
                }
            }
        }
    }
}