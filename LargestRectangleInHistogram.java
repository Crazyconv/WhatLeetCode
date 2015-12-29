// https://siddontang.gitbooks.io/leetcode-solution/content/array/largest_rectangle_in_histogram.html
import java.util.Stack;
public class LargestRectangleInHistogram{
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length <= 0)
            return 0;
        int len = height.length;

        if(len == 1) return height[0];
        int[] dumpHeight = new int[len + 1];
        System.arraycopy(height, 0, dumpHeight, 0, len);
        dumpHeight[len] = 0;

        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            if(s.isEmpty() || dumpHeight[s.peek()] <= dumpHeight[i])
                s.push(i);
            else{
                while(!s.isEmpty() && dumpHeight[s.peek()] > dumpHeight[i]){
                    int top = s.pop();
                    int area = dumpHeight[top] * ((s.isEmpty())? i:(i - s.peek() - 1));
                    if(area > maxArea)
                        maxArea = area;
                }
                s.push(i);
            }
        }
        return maxArea;
    }
    public static void main(String[] argvs){
        LargestRectangleInHistogram lri = new LargestRectangleInHistogram();
        int[] height = {2,1,2};
        System.out.println(lri.largestRectangleArea(height));
    }    
}