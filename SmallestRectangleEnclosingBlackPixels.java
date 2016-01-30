public class SmallestRectangleEnclosingBlackPixels{
    // imagine when you project the matrix to the x-axis (get one if at least one '1' in the column)
    // there must be a continuous sequence of '1'
    // can start from y, do binary search on the left and right side to get the border
    // the same applies to the y-axis
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length <= x || image[0].length <= y)
            return 0;
        int rowNum = image.length;
        int colNum = image[0].length;
        int left = search_h(0, y, rowNum, image, image[x][y], true);
        int right = search_h(y + 1, colNum, rowNum, image, image[x][y], false);
        int top = search_v(0, x, colNum, image, image[x][y], true);
        int bottom = search_v(x + 1, rowNum, colNum, image, image[x][y], false);
        return (right - left) * (bottom - top);
    }    
    public int search_h(int start, int end, int rowNum, char[][] image, int target, boolean one){
        while(start != end){
            int mid = start + (end - start) / 2;
            int row = 0;
            while(row < rowNum && image[row][mid] == '0') 
                row ++;
            if((row == rowNum) == one)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
    public int search_v(int start, int end, int colNum, char[][] image, int target, boolean one){
        while(start != end){
            int mid = start + (end - start) / 2;
            int col = 0;
            while(col < colNum && image[mid][col] == '0') 
                col ++;
            if((col == colNum) == one)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}