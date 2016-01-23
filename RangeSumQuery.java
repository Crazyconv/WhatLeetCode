public class RangeSumQuery{
    /* =========================================================
     *                  use segment tree
     * =========================================================
     */
    int[] sum;
    int pos;
    int N;
    public RangeSumQuery(int[] nums) {
        if(nums != null && nums.length > 0){
            this.N = nums.length;
            this.sum = new int[N << 2];
            this.pos = 0;
            build(0, N - 1, 1, nums);
        }
    }

    void build(int l, int r, int rt, int[] nums){
        if(l == r){
            sum[rt] = nums[pos++];
            return;
        }
        int m = (l + r) >> 1;
        build(l, m, rt << 1, nums);
        build(m + 1, r, rt << 1 | 1, nums);
        pushUp(rt);
    }

    void pushUp(int rt){
        sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
    }

    void update(int i, int val) {
        update(i, val, 0, N - 1, 1);
    }

    void update(int i, int val, int l, int r, int rt){
        if(l == r){
            sum[rt] = val;
            return;
        }
        int m = (l + r) >> 1;
        if(i <= m)
            update(i, val, l, m, rt << 1);
        else
            update(i, val, m + 1, r, rt << 1 | 1);
        pushUp(rt);
    }

    public int sumRange(int i, int j) {
        return sumRange(i, j, 0, N - 1, 1);
    }    

    int sumRange(int L, int R, int l, int r, int rt){
        if(L <= l && R >= r)
            return sum[rt];
        int m = (l + r) >> 1;
        int ret = 0;
        if(L <= m)
            ret += sumRange(L, R, l, m, rt << 1);
        if(R > m)
            ret += sumRange(L, R, m + 1, r, rt << 1 | 1);
        return ret;
    }


    /* =========================================================
     *                  use binary index tree
     * =========================================================
     */

    int[] nums;
    int[] sum;
    int N;

    public RangeSumQuery(int[] nums) {
        this.nums = nums;
        this.N = nums.length;
        this.sum = new int[N + 1];
        for(int i = 0; i < N; i++){
            add(i + 1, nums[i]);
        }
    }
    void update(int i, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }
    void add(int i, int val){
        while(i <= N){
            sum[i] += val;
            i += (i & (-i));
        }
    }
    public int sumRange(int i, int j) {
        return sumAll(j + 1) - sumAll(i);
    }

    int sumAll(int i){
        int ans = 0;
        while(i > 0){
            ans += sum[i];
            i -= (i & (-i));
        }
        return ans;
    }

    public static void main(String[] argvs){
        int[] nums = {1, 3, 5};
        RangeSumQuery rsq = new RangeSumQuery(nums);
        System.out.printf("%d\n", rsq.sumRange(0, 2));
        rsq.update(1, 2);
        System.out.printf("%d\n", rsq.sumRange(0, 2));
    }
}