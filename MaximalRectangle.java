// https://siddontang.gitbooks.io/leetcode-solution/content/array/maximal_rectangle.html
import java.util.Stack;
public class MaximalRectangle{
    public int maximalRectangle(char[][] matrix) {
        if(matrix != null && matrix.length != 0 && matrix[0].length != 0){
            int rowNum = matrix.length;
            int colNum = matrix[0].length;
            int max = -1;
            int[] height = new int[colNum + 1];
            for(int i = 0; i < rowNum; i++){
                for(int j = 0; j < colNum; j++){
                    if(matrix[i][j] == '0')
                        height[j] = 0;
                    else
                        height[j] ++;
                }
                int result = largestRectangleArea(height);
                if(max < result)
                    max = result;
            }
            return max;
        }
        return 0;
    }    
    public int largestRectangleArea(int[] dumpHeight) {
        int len = dumpHeight.length;
        if(len == 1) return dumpHeight[0];

        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i < len; i++){
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
        MaximalRectangle mr = new MaximalRectangle();
        String[] strings = {"0000", "1111", "1110", "0100"};
        char[][] board = new char[strings.length][strings[0].length()];
        for(int i = 0; i < strings.length; i++){
            for(int j = 0; j < strings[0].length(); j++){
                board[i][j] = strings[i].charAt(j);
            }
        }
        System.out.println(mr.maximalRectangle(board));
    }
}