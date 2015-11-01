import java.util.HashSet;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FourSum{
    public static void main(String[] argvs){
        FourSum fs = new FourSum();
        int nums[] = {1, 0, -1, 0, -2, 2};
        fs.print(fs.fourSum2(nums, 0));
    }
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        for(int m = 0; m < nums.length - 3; m++){
            if(m == 0 || nums[m] != nums[m-1]){
                for(int n = m + 1; n < nums.length - 2; n++){
                    if(n == m + 1 || nums[n] != nums[n-1]){
                        int diff = target - nums[m] - nums[n];
                        int i = n + 1, j = nums.length - 1;
                        while(i < j){
                            if(i != n + 1 && nums[i] == nums[i-1])
                                i++;
                            else if(j != nums.length - 1 && nums[j] == nums[j+1])
                                j--;
                            else{
                                int sum = nums[i] + nums[j];
                                if(sum == diff){
                                    ArrayList<Integer> item = new ArrayList<Integer>();
                                    item.add(nums[m]);
                                    item.add(nums[n]);
                                    item.add(nums[i]);
                                    item.add(nums[j]);
                                    result.add(item);
                                    i++;
                                    j--;
                                } else if (sum < diff){
                                    i++;
                                } else {
                                    j--;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    // O(n^2lgn): don't know why exceed time limit
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        ArrayList<Pair> pairs = new ArrayList<Pair>();

        // build pair;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+1; j < nums.length; j++){
                pairs.add(new Pair(nums[i], nums[j]));
            }
        }
        // sort;
        Collections.sort(pairs);
        // perform 2 sum
        int i = 0, j = pairs.size() - 1;
        while(i < j){
            int sum = pairs.get(i).sum + pairs.get(j).sum;
            if(sum < target)
                i++;
            else if (sum < target)
                j--;
            else{
                ArrayList<Integer> ai = new ArrayList<Integer>();
                ai.add(pairs.get(i).first);
                ai.add(pairs.get(i).second);
                ai.add(pairs.get(j).first);
                ai.add(pairs.get(j).second);
                Collections.sort(ai);
                if(!hs.contains(ai)){
                    result.add(ai);
                    hs.add(ai);
                }
                i++;
                j--;
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
    static class Pair implements Comparable{
        int first;
        int second;
        int sum;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
            this.sum = first + second;
        }

        public int compareTo(Object o){
            Pair p = (Pair) o;
            if(sum < p.sum)
                return -1;
            else if(sum > p.sum)
                return 1;
            else
                return 0;
        }
    } 
}