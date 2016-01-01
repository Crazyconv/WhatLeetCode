public class PermutationsII{
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums != null && nums.length != 0){
            boolean[] visited = new boolean[nums.length];
            Arrays.sort(nums);
            permute(nums, visited, 0, new ArrayList<Integer>(), result);
        }
        return result;
    }
    public void permute(int[] nums, boolean[] visited, int pos, 
        ArrayList<Integer> item, ArrayList<List<Integer>> result){
        if(pos == nums.length){
            result.add(new ArrayList(item));
        } else {
            for(int i = 0; i < nums.length; i++){
                if(i == 0 || nums[i] != nums[i-1] || visited[i-1]){
                    if(!visited[i]){
                        visited[i] = true;
                        item.add(nums[i]);
                        permute(nums, visited, pos+1, item, result);
                        item.remove(item.size()-1);
                        visited[i] = false;
                    }
                }
            }
        }
    }

    public List<List<Integer>> permuteIterative(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums != null && nums.length != 0){
            result.add(new ArrayList<Integer>());
            for(int i = 0; i < nums.length; i++){
                HashSet<List<Integer>> next = new HashSet<List<Integer>>();
                for(List<Integer> l : result){
                    for(int j = 0; j <= l.size(); j++){
                        l.add(j, nums[i]);
                        next.add(new ArrayList<Integer>(l));
                        l.remove(j);
                    }
                }
                result = new ArrayList<List<Integer>>(next);
            }
        }
        return result;
    }

    public List<List<Integer>> permuteRecursive(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums != null && nums.length != 0){
            permuteRecursive(nums, 0, result);
        }
        return result;
    }
    public void permuteRecursive(int[] nums, int pos, ArrayList<List<Integer>> result){
        if(pos == nums.length){
            ArrayList<Integer> item = new ArrayList<Integer>(pos);
            for(int i = 0; i < pos; i++){
                item.add(nums[i]);
            }
            result.add(item);
        } else {
            HashSet<Integer> visited = new HashSet<Integer>();
            for(int i = pos; i < nums.length; i++){
                if(!visited.contains(nums[i])){
                    swap(nums, pos, i);
                    permuteRecursive(nums, pos+1, result);
                    swap(nums, i, pos);
                    visited.add(nums[i]);
                }
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}