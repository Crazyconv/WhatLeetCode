import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.HashSet;
public class LongestConsecutiveSequence{
    public static void main(String[] argvs){
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7};
        System.out.println(lcs.longestConsecutive(nums));
    }
    // wrong!!!
    public int longestConsecutive2(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> largeMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> smallMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(largeMap.get(nums[i]) != null || smallMap.get(nums[i]) != null)
                continue;
            Integer largest = largeMap.get(nums[i]+1);
            Integer smallest = smallMap.get(nums[i]-1);
            if(largest == null && smallest == null){
                largeMap.put(nums[i], nums[i]);
                smallMap.put(nums[i], nums[i]);
            } else if (largest != null && smallest != null){
                smallMap.remove(nums[i]-1);
                largeMap.remove(nums[i]+1);
                smallMap.put(largest, smallest);
                largeMap.put(smallest, largest);
            } else if (smallest != null){
                smallMap.remove(nums[i]-1);
                smallMap.put(nums[i], smallest);
                largeMap.put(smallest, nums[i]);
            } else {
                largeMap.remove(nums[i]+1);
                largeMap.put(nums[i], largest);
                smallMap.put(largest, nums[i]);
            }
        }
        int longest = 0;
        for(Map.Entry<Integer, Integer> entry: largeMap.entrySet()){
            int length = (entry.getValue() - entry.getKey()) + 1;
            if(longest < length)
                longest = length;
        }
        return longest;
    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
            hs.add(nums[i]);
        int longest = 0;
        for(int i = 0; i < nums.length; i++){
            if(hs.contains(nums[i])){
                int count = 1;
                int small = nums[i] - 1;
                while(hs.contains(small)){
                    hs.remove(small);
                    count ++;
                    small --;
                }
                int large = nums[i] + 1;
                while(hs.contains(large)){
                    hs.remove(large);
                    count ++;
                    large ++;
                }
                if(count > longest)
                    longest = count;
            }
        }
        return longest;
    }
}