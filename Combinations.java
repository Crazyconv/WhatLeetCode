public class Combinations{
    // public List<List<Integer>> combine(int n, int k) {
    //     ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    //     if(n >= k){
    //         combine(0, k-1, 1, n, new ArrayList<Integer>(), result);
    //     }
    //     return result;
    // }    
    // public void combine(int pos, int k, int start, int n, ArrayList<Integer> item, ArrayList<List<Integer>> result){
    //     if(k - pos == n - start){
    //         for(int i = start; i <= n; i++){
    //             item.add(i);
    //         }
    //         result.add(item);
    //     } else if (pos > k){
    //         result.add(item);
    //     } else {
    //         ArrayList<Integer> item2 = new ArrayList<Integer>(item);
    //         item2.add(start);
    //         combine(pos, k, start + 1, n, item, result);
    //         combine(pos + 1, k, start + 1, n, item2, result);
    //     }
    // }
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n >= k){
            combine(k, n, 1, new ArrayList<Integer>(), result);
        }
        return result;
    }    
    public void combine(int k, int n, int start, ArrayList<Integer> item, ArrayList<List<Integer>> result){
        if(item.size() == k){
            result.add(new ArrayList<Integer>(item));
        } else {
            for(int i = start; i <= n+1+item.size()-k; i++){
                item.add(i);
                combine(k, n, i+1, item, result);
                item.remove(item.size()-1);
            }
        }
    }
}