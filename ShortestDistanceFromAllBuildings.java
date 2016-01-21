public class ShortestDistanceFromAllBuildings{
    // use flag to track squares reacheable from last building
    // use linkedlist: 17ms
    // use arraylist: 16ms
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int rowNum = grid.length;
        int colNum = grid[0].length;
        int[][] flag = new int[rowNum][colNum];
        int[][] dist = new int[rowNum][colNum];
        System.arraycopy(grid, 0, flag, 0, rowNum);

        int mark = 0;
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i = 0; i < rowNum; i ++){
            for(int j = 0; j < colNum; j ++){
                if(grid[i][j] == 1){
                    int level = 1;
                    ArrayList<Pair> pre = new ArrayList<Pair>();
                    ArrayList<Pair> cur = new ArrayList<Pair>();
                    pre.add(new Pair(i, j));
                    while(pre.size() != 0){
                        for(Pair p : pre){
                            for(int[] step : move){
                                int tempRow = p.row + step[0];
                                int tempCol = p.col + step[1];
                                if(tempRow >= 0 && tempRow < rowNum &&
                                    tempCol >= 0 && tempCol < colNum &&
                                    flag[tempRow][tempCol] == mark){
                                    dist[tempRow][tempCol] += level;
                                    cur.add(new Pair(tempRow, tempCol));
                                    flag[tempRow][tempCol] --;
                                }
                            }
                        }
                        level ++;
                        pre = cur;
                        cur = new ArrayList<Pair>();
                    }
                    mark --;
                }
            }
        }

        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(flag[i][j] == mark && minDist > dist[i][j])
                    minDist = dist[i][j];
            }
        }
        return (minDist == Integer.MAX_VALUE)? -1 : minDist;
    }    
}

class Pair{
    int row, col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}