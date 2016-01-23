public class RangeSumQuery2D{
    /* =========================================================
     *                  use 2D binary index tree
     * =========================================================
     */
    //O(k * lg(m) * lg(n))
    int[][] sum;
    int[][] matrix;
    int Nr, Nc;
    public RangeSumQuery2D(int[][] matrix) {
        if(matrix != null && matrix.length > 0 && matrix[0].length > 0){
            this.matrix = matrix;
            Nr = matrix.length;
            Nc = matrix[0].length;
            this.sum = new int[Nr + 1][Nc + 1];

            for(int i = 1; i <= Nr; i ++){
                for(int j = 1; j <= Nc; j++){
                    add(i, j, matrix[i-1][j-1]);
                }
            }
        }
    }

    void add(int row, int col, int val){
        while(row <= Nr){
            int iCol = col;
            while(iCol <= Nc){
                sum[row][iCol] += val;
                iCol += (iCol & (-iCol));
            }
            row += (row & (-row));
        }
    }

    int sumAll(int row, int col){
        int ans = 0;
        while(row > 0){
            int iCol = col;
            while(iCol > 0){
                ans += sum[row][iCol];
                iCol -= (iCol & (-iCol));
            }
            row -= (row & (-row));
        }
        return ans;
    }

    public void update(int row, int col, int val) {
        add(row + 1, col + 1, val - matrix[row][col]);
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumAll(row2 + 1, col2 + 1) + sumAll(row1, col1) - sumAll(row2 + 1, col1) - sumAll(row1, col2 + 1);
    }  

    /* =========================================================
     *                    use 2D segment tree
     * =========================================================
     */
    //O(k * lgm * lgn)
    int[][] sum;
    int[][] matrix;
    int Nr, Nc;
    public RangeSumQuery2D(int[][] matrix) {
        if(matrix != null && matrix.length > 0 && matrix[0].length > 0){
            Nr = matrix.length;
            Nc = matrix[0].length;
            this.matrix = new int[Nr][Nc];
            this.sum = new int[Nr << 2][Nc << 2];

            for(int i = 0; i < Nr; i ++){
                for(int j = 0; j < Nc; j++){
                    update(i, j, matrix[i][j]);
                }
            }
        }
    }

    void updateY(int xrt, int col, int val, int l, int r, int rt){
        sum[xrt][rt] += val;
        if(l < r){
            int mid = (l + r) >> 1;
            if(col <= mid)
                updateY(xrt, col, val, l, mid, rt << 1);
            else
                updateY(xrt, col, val, mid + 1, r, rt << 1 | 1);
        }
    }

    void updateX(int row, int col, int val, int l, int r, int rt){
        updateY(rt, col, val, 0, Nc - 1, 1);
        if(l < r){
            int mid = (l + r) >> 1;
            if(row <= mid)
                updateX(row, col, val, l, mid, rt << 1);
            else
                updateX(row, col, val, mid + 1, r, rt << 1 | 1);
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        updateX(row, col, diff, 0, Nr - 1, 1);
        matrix[row][col] = val;
    }

    int queryY(int xrt, int col1, int col2, int l, int r, int rt){
        if(col1 <= l && col2 >= r){
            return sum[xrt][rt];
        }
        int ret = 0;
        int mid = (l + r) >> 1;
        if(col1 <= mid)
            ret += queryY(xrt, col1, col2, l, mid, rt << 1);
        if(col2 > mid)
            ret += queryY(xrt, col1, col2, mid + 1, r, rt << 1 | 1);
        return ret;
    }

    int queryX(int row1, int col1, int row2, int col2, int l, int r, int rt){
        if(row1 <= l && row2 >= r)
            return queryY(rt, col1, col2, 0, Nc - 1, 1);
        int ret = 0;
        int mid = (l + r) >> 1;
        if(row1 <= mid)
            ret += queryX(row1, col1, row2, col2, l, mid, rt << 1);
        if(row2 > mid)
            ret += queryX(row1, col1, row2, col2, mid + 1, r, rt << 1 | 1);
        return ret;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return queryX(row1, col1, row2, col2, 0, Nr - 1, 1);
    } 


    /* =========================================================
     *                       row sum
     * =========================================================
     */
    O(k * (m + n))
    int[][] sum;
    int[][] matrix;
    int Nr, Nc;
    public RangeSumQuery2D(int[][] matrix) {
        if(matrix != null && matrix.length > 0 && matrix[0].length > 0){
            this.matrix = matrix;
            Nr = matrix.length;
            Nc = matrix[0].length;
            this.sum = new int[Nr + 1][Nc + 1];

            for(int i = 1; i <= Nr; i ++){
                for(int j = 1; j <= Nc; j++){
                    sum[i][j] = sum[i][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        for(int j = col + 1; j <= Nc; j++){
            sum[row + 1][j] += diff;
        }
        matrix[row][col] = val;
    }

    int sumAll(int row, int col){
        int ans = 0;
        for(int i = 0; i <= row; i++){
            ans += sum[i][col];
        }
        return ans;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumAll(row2 + 1, col2 + 1) + sumAll(row1, col1) - sumAll(row2 + 1, col1) - sumAll(row1, col2 + 1);
    }  


    public static void main(String[] argvs){
        int[][] matrix = {
                          {3, 0, 1, 4, 2},
                          {5, 6, 3, 2, 1},
                          {1, 2, 0, 1, 5},
                          {4, 1, 0, 1, 7},
                          {1, 0, 3, 0, 5}
                        };
        RangeSumQuery2D rs = new RangeSumQuery2D(matrix);
        System.out.printf("%d\n", rs.sumRegion(2, 1, 4, 3));
        rs.update(3, 2, 2);
        System.out.printf("%d\n", rs.sumRegion(2, 1, 4, 3));
    }  
}