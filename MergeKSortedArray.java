import java.util.PriorityQueue;
import java.util.Arrays;
public class MergeKSortedArray{
    public int[] mergeKSortedArray(int[][] arr){
        PriorityQueue<ArrayContainer> pq = new PriorityQueue<ArrayContainer>();
        int length = 0;
        for(int i = 0; i < arr.length; i++){
            pq.add(new ArrayContainer(arr[i]));
            length += arr[i].length;
        }
        int[] result = new int[length];
        for(int i = 0; i < length; i++){
            ArrayContainer ac = pq.poll();
            result[i] = ac.arr[ac.index];
            if(ac.index < ac.arr.length - 1){
                ac.index ++;
                pq.add(ac);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        MergeKSortedArray ms = new MergeKSortedArray();
        int[] result = ms.mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(result));
    }
}

class ArrayContainer implements Comparable<ArrayContainer>{
    int[] arr;
    int index;
    public ArrayContainer(int[] arr){
        this.arr = arr;
        index = 0;
    }
    public int compareTo(ArrayContainer o){
        if(arr[index] < o.arr[o.index])
            return -1;
        else if(arr[index] > o.arr[o.index])
            return 1;
        else
            return 0;
    }
}