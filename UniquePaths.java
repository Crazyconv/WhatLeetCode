public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m > 0 && n > 0){
            int[] sum = new int[m];
            for(int j = 0; j < n; j++){
                for(int i = 0; i < m; i++){
                    if(j == 0)
                        sum[i] = 1;
                    else if(i != 0)
                        sum[i] = sum[i] + sum[i-1];
                }
            }
            return sum[m-1];
        }
        return 0;
    }    
}