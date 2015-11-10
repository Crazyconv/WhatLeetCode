import java.util.TreeSet;
import java.util.SortedSet;
public class ContainsDuplicateIII{
    public static void main(String[] argvs){
        ContainsDuplicateIII cd = new ContainsDuplicateIII();
        int[] nums = {1,2,3,2};
        System.out.println(cd.containsNearbyAlmostDuplicate(nums, 1, 1));
        System.out.println(cd.containsNearbyAlmostDuplicate(nums, 2, 1));
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        if(k == 0) return false;
        TreeSet<Integer> s = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i ++){
            if((s.floor(nums[i]) != null && s.floor(nums[i]) + t >= nums[i]) ||
                (s.ceiling(nums[i]) != null && s.ceiling(nums[i]) - t <= nums[i]))
                return true;
            s.add(nums[i]);
            if(i >= k)
                s.remove(nums[i-k]);
        } 
        return false;
    }
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t){
        if(k == 0) return false;
        TreeSet<Long> s = new TreeSet<Long>();
        for(int i = 0; i < nums.length; i ++){
            SortedSet<Long> subSet = null;
            if(t > 0)
                subSet = s.subSet((long)nums[i] - t, (long)nums[i] + t + 1);
            else
                subSet = s.subSet((long)nums[i] + t, (long)nums[i] - t + 1);
            if(!subSet.isEmpty())
                return true;
            s.add((long)nums[i]);
            if(i >= k)
                s.remove((long)nums[i-k]);
        } 
        return false;  
    }    
}