// http://bookshadow.com/weblog/2014/12/14/leetcode-maximum-gap/
public class MaximumGap{
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length <= 1)
            return 0;

        int len = nums.length;
        int max = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            if(nums[i] < min)
                min = nums[i];
            if(nums[i] > max)
                max = nums[i];
        }

        int interval = (max - min - 1) / (len - 1) + 1;   // ceil((max-min)/(len-1))
        int bucketNum = (max - min) / interval + 1; // ceil((max-min+1)/(interval))
        int[] bucketMin = new int[bucketNum];
        int[] bucketMax = new int[bucketNum];
        for(int i = 0; i < bucketNum; i++){
            bucketMin[i] = -1;
            bucketMax[i] = -1;
        }

        for(int i = 0; i < len; i++){
            int bi = (nums[i] - min) / interval;
            if(bucketMax[bi] < nums[i])
                bucketMax[bi] = nums[i];
            if(bucketMin[bi] == -1 || bucketMin[bi] > nums[i])
                bucketMin[bi] = nums[i];
        }

        int maxGap = 0;
        int preMax = bucketMax[0];
        for(int i = 1; i < bucketNum; i++){
            if(bucketMin[i] != -1){
                if(maxGap < bucketMin[i] - preMax)
                    maxGap = bucketMin[i] - preMax;
                preMax = bucketMax[i];
            }
        }
        return maxGap;
    }    
    public static void main(String[] argvs){
        int[] nums = {4,11};
        MaximumGap mg = new MaximumGap();
        System.out.println(mg.maximumGap(nums));
    }
}