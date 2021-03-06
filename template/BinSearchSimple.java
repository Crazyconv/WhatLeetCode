public class BinSearchSimple{
    public int findFirstLarger(int[] arr, int target){
        if(arr.length == 0)
            return -1;
        int start = 0, end = arr.length;
        while(start != end){
            int mid = start + (end - start)/2;
            if(arr[mid] <= target)
                start = mid + 1;
            else
                end = mid;
        }
        return end;
    }
    public int findLastSmaller(int[] arr, int target){
        if(arr.length == 0)
            return -1;
        int start = -1, end = arr.length - 1;
        while(start != end){
            int mid =  start + (end + 1 - start)/2;
            if(arr[mid] >= target)
                end = mid - 1;
            else
                start = mid;
        }
        return start;
    }
    public int findFirstLargerOrEqual(int[] arr, int target){
        if(arr.length == 0)
            return -1;
        int start = 0, end = arr.length;
        while(start != end){
            int mid = start + (end - start)/2;
            if(arr[mid] < target)
                start = mid + 1;
            else
                end = mid;
        }
        return end;        
    }
    public int findLastSmallerOrEqual(int[] arr, int target){
        if(arr.length == 0)
            return -1;
        int start = -1, end = arr.length -1 ;
        while(start != end){
            int mid =  start + (end + 1 - start)/2;
            if(arr[mid] > target)
                end = mid - 1;
            else
                start = mid;
        }
        return start;        
    }
    public static void main(String[] argvs){
        BinSearchSimple bs = new BinSearchSimple();
        int arr[] = {1,2,2,3,4,4,5,6};
        System.out.println(bs.findFirstLarger(arr, 2)); // 3
        System.out.println(bs.findFirstLarger(arr, 4)); // 6
        System.out.println(bs.findFirstLarger(arr, 0)); // 0
        System.out.println(bs.findFirstLarger(arr, 1)); // 1
        System.out.println(bs.findFirstLarger(arr, 6)); // 8
  
        System.out.println(bs.findLastSmaller(arr, 2)); // 0
        System.out.println(bs.findLastSmaller(arr, 4)); // 3
        System.out.println(bs.findLastSmaller(arr, 1)); // -1
        System.out.println(bs.findLastSmaller(arr, 6)); // 6
        System.out.println(bs.findLastSmaller(arr, 7)); // 7

        System.out.println(bs.findFirstLargerOrEqual(arr, 2)); // 1
        System.out.println(bs.findFirstLargerOrEqual(arr, 4)); // 4
        System.out.println(bs.findFirstLargerOrEqual(arr, 0)); // 0
        System.out.println(bs.findFirstLargerOrEqual(arr, 6)); // 7
        System.out.println(bs.findFirstLargerOrEqual(arr, 7)); // 8

        System.out.println(bs.findLastSmallerOrEqual(arr, 2)); // 2
        System.out.println(bs.findLastSmallerOrEqual(arr, 4)); // 5
        System.out.println(bs.findLastSmallerOrEqual(arr, 0)); // -1
        System.out.println(bs.findLastSmallerOrEqual(arr, 6)); // 7
        System.out.println(bs.findLastSmallerOrEqual(arr, 7)); // 7
    }
}