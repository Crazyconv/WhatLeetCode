public class MedianTwoArrays{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if((len2 + len1) % 2 == 1)
            return findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len2+len1)/2);
        else
            return (findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len2+len1)/2) +
                findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len2+len1-1)/2)) / 2.0; 
    }
    public int findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if(len1 <= 0)
            return nums2[start2 + k];
        if(len2 <= 0)
            return nums1[start1 + k];
        if(k == 0)
            return (nums1[start1] < nums2[start2]) ? nums1[start1] : nums2[start2];

        int size1 = k * len1 / (len1 + len2) + 1;
        int size2 = k + 1 - size1;
        int index1 = start1 + size1 - 1;
        int index2 = start2 + size2 - 1;
        if(nums1[index1] == nums2[index2])
            return nums1[index1];
        else if(nums1[index1] < nums2[index2])
            return findKth(nums1, index1 + 1, end1, nums2, start2, index2, k - size1);
        else
            return findKth(nums1, start1, index1, nums2, index2 + 1, end2, k - size2);
    }
    public static void main(String[] argvs){
        MedianTwoArrays mta = new MedianTwoArrays();
        int[] nums1 = {1,2};
        int[] nums2 = {1,2};
        int[] nums3 = {2,4,9,10};
        System.out.println(mta.findMedianSortedArrays(nums1, nums2));
        System.out.println(mta.findMedianSortedArrays(nums1, nums3));
    }
}