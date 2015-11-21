public class LongestIncreasingSubsequence{
    /**********************************************************************
     **                        Dynamic Programming                       **
     **********************************************************************/
    // O(n^2)
    // if multiple lis, want the smallest start index and smallest end index
    public void naive(int[] arr){
        int[] lis = new int[arr.length];
        int[] prev = new int[arr.length];
        int maxLength = 1, maxEndIndex = 0;

        // initialize
        for(int i = 0; i < arr.length; i++){
            lis[i] = 1;
            prev[i] = -1;
        }
        for(int i = 1; i < arr.length; i ++){
            for(int j = i-1; j >= 0; j --){
                if(arr[i] > arr[j] && lis[i] <= lis[j] + 1){
                    lis[i] = lis[j] + 1;
                    prev[i] = j;
                }
                if(lis[i] > maxLength){
                    maxLength = lis[i];
                    maxEndIndex = i;
                }
            }
        } 

        // print sequence
        System.out.printf("LIS[%d]: ", maxLength);
        for(int i = maxEndIndex; i >= 0; i = prev[i]){
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    /**********************************************************************
     **                            Unknown name                          **
     **********************************************************************/
    // O(nlogn)
    // strictly increasing
    // if multiple lis, want the largest start index and largest end index
    // http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    public int findFirstLargerInclusive(int[] lis, int[] arr, int end, int target){
        int start = 0;
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[lis[mid]] < target)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    public void getLIS(int[] arr){
        int[] lis = new int[arr.length];   // store index
        int[] prev = new int[arr.length];   // store index
        int len = 1;
        lis[0] = 0;
        prev[0] = -1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[lis[0]]){
                lis[0] = i;
                prev[i] = -1;
            } else if(arr[i] > arr[lis[len-1]]){
                lis[len] = i;
                prev[i] = lis[len-1];
                len ++;
            } else {
                int fli = findFirstLargerInclusive(lis, arr, len - 1, arr[i]);
                lis[fli] = i;
                prev[i] = lis[fli-1];
            }
        }
        System.out.printf("LIS[%d]: ", len);
        for(int i = lis[len - 1]; i >= 0; i = prev[i]){
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();        
    }



    public static void main(String[] argvs){
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        lis.naive(arr);
    }    
}