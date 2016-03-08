import java.util.Arrays;
public class MergeSortedArray{
    public static void main(String[] argvs){
        MergeSortedArray msa = new MergeSortedArray();
        int[] nums1 = {1,3,6,8,0,0,0};
        int[] nums2 = {2,4,5};
        msa.merge2(nums1, 4, nums2, 3);
        msa.print(nums1);
    }
    // use intermediate array
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int[] temp = Arrays.copyOf(nums1, m);
        int i = 0, j = 0, k = 0;
        while(k < m + n){
            if(i == m || (j < n && temp[i] > nums2[j]))
                nums1[k++] = nums2[j++];
            else
                nums1[k++] = temp[i++];
        }
    }
    // do not use intermediate array
    public void merge2(int[] nums1, int m, int[] nums2, int n){
        int i = m-1, j = n-1, k = m+n-1;
        while(k >= 0){
            if(i < 0 || (j >=0 && nums1[i] < nums2[j]))
                nums1[k--] = nums2[j--];
            else
                nums1[k--] = nums1[i--];
        }
    }
    public void print(int[] nums1){
        for(int i: nums1){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}