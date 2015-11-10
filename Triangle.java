import java.util.List;
import java.util.ArrayList;
public class Triangle{
    public static void main(String[] argvs){
        Triangle t = new Triangle();
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();
        ArrayList<Integer> third = new ArrayList<Integer>();
        ArrayList<Integer> fourth = new ArrayList<Integer>();
        first.add(2);
        second.add(3); second.add(4);
        third.add(6); third.add(5); third.add(7);
        fourth.add(4); fourth.add(1); fourth.add(8); fourth.add(3);
        input.add(first); input.add(second); input.add(third); input.add(fourth);
        System.out.println(t.minimumTotal(input));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if(rows == 0)
            return 0;

        int pre[] = new int[rows];
        int cur[] = new int[rows];
        pre[0] = triangle.get(0).get(0);
        for(int i = 1; i < rows; i++){
            List<Integer> inner = triangle.get(i);
            cur[0] = inner.get(0) + pre[0];
            int j;
            for(j = 1; j < inner.size() - 1; j++){
                cur[j] = ((pre[j-1] < pre[j])? pre[j-1] : pre[j]) + inner.get(j);
            }
            cur[j] = pre[j - 1] + inner.get(j);
            System.arraycopy(cur, 0, pre, 0, i + 1);
        }
        return min(pre);
    }
    public int min(int[] arr){
        int result = arr[0];
        for(int i = 1; i < arr.length; i ++){
            if(arr[i] < result)
                result = arr[i];
        }
        return result;
    }
}