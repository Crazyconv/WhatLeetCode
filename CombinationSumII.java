public class CombinationSumII{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates != null && candidates.length > 0){
            Arrays.sort(candidates);
            combine(candidates, target, 0, new ArrayList<Integer>(), result);
        }
        return result;
    }    
    public void combine(int[] candidates, int target, int pos, ArrayList<Integer> item, ArrayList<List<Integer>> result){
        if(target == 0)
            result.add(new ArrayList<Integer>(item));
        else {
            for(int i = pos; i < candidates.length && candidates[i] <= target; i++){
                if(i == pos || candidates[i] != candidates[i-1]){
                    item.add(candidates[i]);
                    combine(candidates, target - candidates[i], i+1, item, result);
                    item.remove(item.size() - 1);
                }
            }
        }
    }  
}