import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class ContainsDuplicateII{
    public static void main(String[] argvs){
        ContainsDuplicateII cd = new ContainsDuplicateII();
        int[] nums = {1,2,3,2};
        System.out.println(cd.containsNearbyDuplicate(nums, 1));
        System.out.println(cd.containsNearbyDuplicate(nums, 2));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k){
        HashMap<Integer, List<Integer>> s = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < nums.length; i ++){
            int num = nums[i];
            if(s.containsKey(num)){
                List<Integer> indices = s.get(num);
                for(int index: indices){
                    if(Math.abs(index-i) <= k)
                        return true;
                }
                indices.add(i);
            }
            else{
                ArrayList<Integer> indices = new ArrayList<Integer>();
                indices.add(i);
                s.put(num, indices);
            }
        } 
        return false;
    }
}