import java.util.HashSet;
public class ContainsDuplicate{
    public static void main(String[] argvs){
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] nums = {1,2,3,4};
        System.out.println(cd.containsDuplicate(nums));
    }
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> s = new HashSet<Integer>();
        for(Integer num: nums){
            if(s.contains(num))
                return true;
            else
                s.add(num);
        } 
        return false;
    }
}