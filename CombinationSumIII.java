public class CombinationSumIII{
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n >= (1+k)*k/2 && n <= (19-k)*k/2){
            combine(1, k, n, new ArrayList<Integer>(), result);
        }
        return result;
    }    
    public void combine(int start, int k, int n, ArrayList<Integer> item, ArrayList<List<Integer>> result){
        if(k == 0){
            if(n == 0)
                result.add(new ArrayList<Integer>(item));
        } else {
            int i = n - (k - 1) * 9;
            if(i < start)
                i = start;
            while(i <= 9 && i <= n - (k - 1) * (i + 1)){
                item.add(i);
                combine(i + 1, k - 1, n - i, item, result);
                item.remove(item.size() - 1);
                i++;
            }
        }
    }  
}