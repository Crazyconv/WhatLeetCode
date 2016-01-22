public class SparseMatrixMultiplication{
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, k = B.length, n = B[0].length;
        int[][] result = new int[m][n];

        HashMap<Integer, HashMap<Integer, Integer>> ma = new HashMap<Integer, HashMap<Integer, Integer>>();
        HashMap<Integer, HashMap<Integer, Integer>> mb = new HashMap<Integer, HashMap<Integer, Integer>>();

        for(int i = 0; i < k; i++){
            ma.put(i, new HashMap<Integer, Integer>());
            mb.put(i, new HashMap<Integer, Integer>());
        } 

        for(int i = 0; i < m; i++){
            for(int j = 0; j < k; j++){
                if(A[i][j] != 0)
                    ma.get(j).put(i, A[i][j]);
            }
        }

        for(int i = 0; i < k; i++){
            for(int j = 0; j < n; j++){
                if(B[i][j] != 0)
                    mb.get(i).put(j, B[i][j]);
            }
        }

        for(Integer key : ma.keySet()){
            HashMap<Integer, Integer> va = ma.get(key);
            HashMap<Integer, Integer> vb = mb.get(key);
            if(va != null && vb != null){
                for(Integer i: va.keySet()){
                    for(Integer j: vb.keySet()){
                        result[i][j] += va.get(i) * vb.get(j);
                    }
                }
            }
        }
        return result;
    }
}