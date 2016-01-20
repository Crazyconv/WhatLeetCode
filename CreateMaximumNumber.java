public class CreateMaximumNumber{
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] count = new int[10];
        int[] result = new int[k];

        for(int i = 0; i < nums1.length; i++){
            count[nums1[i]] ++;
        }
        for(int i = 0; i < nums2.length; i++){
            count[nums2[i]] ++;
        }
        for(int i = 8; i >= 0; i --){
            count[i] += count[i+1];
        }
        int index = 0;
        for(int )
    }
}