import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class ThreeSum{
    public List<List<Integer>> threeSum(int[] nums){
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int target = 0 - nums[i];
            if(i == 0 || nums[i] != nums[i-1]){
                int j = i + 1, k = nums.length - 1;
                while(j < k){
                    if(j != i + 1 && nums[j] == nums[j-1]){
                        j ++;
                        continue;
                    }
                    if(k != nums.length - 1 && nums[k] == nums[k+1]){
                        k --;
                        continue;
                    }
                    if(nums[j] + nums[k] == target){
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        result.add(item);
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] < target){
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }
    public void print(List<List<Integer>> numLists){
        for(List<Integer> numList: numLists){
            for(Integer num: numList){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] argvs){
        ThreeSum ts = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ts.print(ts.threeSum(nums));
        int[] nums2 = {0, 0, 0, 0};
        ts.print(ts.threeSum(nums2));
    }
}