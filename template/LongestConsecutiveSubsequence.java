import java.util.HashSet;
public class LongestConsecutiveSubsequence{
    public void getLCS(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
            hs.add(nums[i]);
        int longest = 0, smallest = 0, largest = 0;
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
                if(count > longest){
                    longest = count;
                    smallest = small + 1;
                    largest = large - 1;
                }
            }
        }
        if(longest > 1){
            System.out.printf("LCS[%d]: ", longest);
            while(smallest <= largest){
                System.out.printf("%d ", smallest);
                smallest ++;
            }
            System.out.println();
        } else {
            System.out.println("No LCS.");
        }
    }
    public static void main(String[] argvs){
        LongestConsecutiveSubsequence lcs = new LongestConsecutiveSubsequence();
        int[] nums = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42};
        lcs.getLCS(nums);
    }
}