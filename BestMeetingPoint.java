public class BestMeetingPoint{
    // the meeting point is the median of both axises
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        ArrayList<Integer> h = new ArrayList<Integer>();
        ArrayList<Integer> v = new ArrayList<Integer>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1)
                    h.add(i);
            }
        }
        for(int j = 0; j < n; j++){
            for(int i = 0; i < m; i++){
                if(grid[i][j] == 1)
                    v.add(j);
            }
        }
        return minTotalDistance1D(h) + minTotalDistance1D(v);
    }    
    public int minTotalDistance1D(ArrayList<Integer> arr){
        int d = 0;
        int i = 0, j = arr.length - 1;
        while(i < j){
            d += arr.get(j) - arr.get(i);
            i++;
            j--;
        }
        return d;
    }

    // bucket sort
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] v = new int[m];
        int[] h = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                v[i] += grid[i][j];
                h[j] += grid[i][j];
            }
        }
        return minTotalDistance1D(h) + minTotalDistance1D(v);
    }    
    public int minTotalDistance1D(int[] arr){
        int d = 0;
        int i = 0, j = arr.length - 1;
        while(i < j){
            int k = Math.min(arr[i], arr[j]);
            d += (j - i) * k;
            if((arr[i] -= k) == 0)
                i++;
            if((arr[j] -= k) == 0)
                j--;
        }
        return d;
    }    

    // two pointers
    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] v = new int[m];
        int[] h = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                v[i] += grid[i][j];
                h[j] += grid[i][j];
            }
        }
        return minTotalDistance1D(h) + minTotalDistance1D(v);
    }    
    public int minTotalDistance1D(int[] arr){
        int d = 0;
        int i = 0, j = arr.length - 1;
        int left = arr[i], right = arr[j];
        while(i < j){
            if(left < right){
                d += left;
                i ++;
                left += arr[i];
            } else {
                d += right;
                j --;
                right += arr[j];
            }
        }
        return d;
    }      
}