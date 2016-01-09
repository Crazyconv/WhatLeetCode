public class SubsetsII{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums.length > 0){
            subsets(nums, 0, new ArrayList<Integer>(), results);
        }
        return results;
    }    
    public void subsets(int[] nums, int pos, ArrayList<Integer> item, ArrayList<List<Integer>> results){
        if(pos >= nums.length)
            results.add(item);
        else {
            ArrayList<Integer> item2 = new ArrayList<Integer>(item);
            item2.add(nums[pos]);
            subsets(nums, pos+1, item2, results);
            if(pos == 0 || (nums[pos] != nums[pos-1]) || item.size() == 0 || (item.get(item.size()-1)) != nums[pos]){
                subsets(nums, pos+1, item, results);
            }
        }
    }  
}