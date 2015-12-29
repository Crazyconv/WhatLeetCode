import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
public class NumberOfIslands{
    public int numIslandsDFS(char[][] grid){
        if(grid != null && grid.length != 0 && grid[0].length !=0){
            int rowNum = grid.length;
            int colNum = grid[0].length;
            int count = 0;
            for(int i = 0; i < rowNum; i++){
                for(int j = 0; j < colNum; j++){
                    if(grid[i][j] == '1'){
                        count ++;
                        Stack<Cell> ll = new Stack<Cell>();
                        ll.push(new Cell(i, j));
                        grid[i][j] = '2';
                        while(!ll.isEmpty()){
                            Cell cell = ll.pop();
                            if(cell.row - 1 >= 0 && grid[cell.row-1][cell.col] == '1'){
                                ll.push(new Cell(cell.row - 1, cell.col));
                                grid[cell.row-1][cell.col] = '2';
                            }
                            if(cell.row + 1 < rowNum && grid[cell.row+1][cell.col] == '1'){
                                ll.push(new Cell(cell.row + 1, cell.col));
                                grid[cell.row+1][cell.col] = '2';
                            }
                            if(cell.col - 1 >= 0 && grid[cell.row][cell.col-1] == '1'){
                                ll.push(new Cell(cell.row, cell.col - 1));
                                grid[cell.row][cell.col-1] = '2';
                            }
                            if(cell.col + 1 < colNum && grid[cell.row][cell.col+1] == '1'){
                                ll.push(new Cell(cell.row, cell.col + 1));
                                grid[cell.row][cell.col+1] = '2';
                            }
                        }
                    }
                }
            }
            return count;
        }
        return 0;
    }
    public int numIslandsBFS(char[][] grid){
        if(grid != null && grid.length != 0 && grid[0].length !=0){
            int rowNum = grid.length;
            int colNum = grid[0].length;
            int count = 0;
            for(int i = 0; i < rowNum; i++){
                for(int j = 0; j < colNum; j++){
                    if(grid[i][j] == '1'){
                        count ++;
                        LinkedList<Cell> ll = new LinkedList<Cell>();
                        ll.offer(new Cell(i, j));
                        grid[i][j] = '2';
                        while(!ll.isEmpty()){
                            Cell cell = ll.poll();
                            if(cell.row - 1 >= 0 && grid[cell.row-1][cell.col] == '1'){
                                ll.offer(new Cell(cell.row - 1, cell.col));
                                grid[cell.row-1][cell.col] = '2';
                            }
                            if(cell.row + 1 < rowNum && grid[cell.row+1][cell.col] == '1'){
                                ll.offer(new Cell(cell.row + 1, cell.col));
                                grid[cell.row+1][cell.col] = '2';
                            }
                            if(cell.col - 1 >= 0 && grid[cell.row][cell.col-1] == '1'){
                                ll.offer(new Cell(cell.row, cell.col - 1));
                                grid[cell.row][cell.col-1] = '2';
                            }
                            if(cell.col + 1 < colNum && grid[cell.row][cell.col+1] == '1'){
                                ll.offer(new Cell(cell.row, cell.col + 1));
                                grid[cell.row][cell.col+1] = '2';
                            }
                        }
                    }
                }
            }
            return count;
        }
        return 0;
    }
    public int numIslandsUF(char[][] grid) {
        if(grid != null && grid.length != 0 && grid[0].length != 0){
            int rowNum = grid.length;
            int colNum = grid[0].length;
            int p[] = new int[rowNum * colNum];
            for(int i = 0; i < rowNum; i++){
                for(int j = 0; j < colNum; j++){
                    if(grid[i][j] == '0')
                        p[i * colNum + j] = -1;
                    else
                        p[i * colNum + j] = i * colNum + j;
                }
            }
            for(int i = 0; i < rowNum; i++){
                for(int j = 0; j < colNum; j++){
                    if(grid[i][j] == '1'){
                        int y = find(i * colNum + j, p);
                        if(j+1 < colNum && grid[i][j+1] == '1'){
                            int x = find(i * colNum + j + 1, p);
                            if(x != y)
                                p[x] = y;
                        }
                        if(i+1 < rowNum && grid[i+1][j] == '1'){
                            int x = find((i + 1) * colNum + j, p);
                            if(x != y)
                                p[x] = y;
                        }
                    }
                }
            }

            int count = 0;
            HashSet<Integer> islands = new HashSet<Integer>();
            for(int i = 0; i < rowNum * colNum; i++){
                if(p[i] != -1){
                    p[i] = find(i, p);
                    if(!islands.contains(p[i])){
                        islands.add(p[i]);
                        count ++;
                    }
                }
            }
            return count;
        }
        return 0;
    }
    public int find(int x, int[] p){
        return (p[x] == x)? x:(p[x] = find(p[x], p));
    }
    public static void main(String[] argvs){
        NumberOfIslands noi = new NumberOfIslands();
        String[] nums = {"11111011111111101011","01111111111110111110","10111001101111111111","11110111111111111111","10011111111111111111","10111111011101110111","01111111111101101111","11111111111101111011","11111111110111111111","11111111111111111111","01111111011111111111","11111111111111111111","11111111111111111111","11111011111110111111","10111110111011110111","11111111111101111110","11111111111110111100","11111111111111111111","11111111111111111111","11111111111111111111"};
        //String[] nums = {"1"};
        char[][] chars = new char[nums.length][nums[0].length()];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[0].length(); j++){
                chars[i][j] = nums[i].charAt(j);
            }
        }
        System.out.println(noi.numIslands(chars));
    }    
}
class Cell{
    int row;
    int col;
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
}