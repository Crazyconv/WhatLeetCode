import java.util.LinkedList;
public class SurroundedRegions{
    public static final int[][] neis = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void solve(char[][] board) {
        if(board != null && board.length != 0 && board[0].length != 0){
            int rowNum = board.length;
            int colNum = board[0].length;
            // top
            for(int j = 0; j < colNum; j++){
                if(board[0][j] == 'O')
                    BFS(board, 0, j, rowNum, colNum);
                if(board[rowNum - 1][j] == 'O')
                    BFS(board, rowNum - 1, j, rowNum, colNum);
            }
            for(int i = 1; i < rowNum - 1; i++){
                if(board[i][0] == 'O')
                    BFS(board, i, 0, rowNum, colNum);
                if(board[i][colNum - 1] == 'O')
                    BFS(board, i, colNum - 1, rowNum, colNum);
            }
            for(int i = 0; i < rowNum; i++){
                for(int j = 0; j < colNum; j++){
                    if(board[i][j] == '#')
                        board[i][j] = 'O';
                    else if(board[i][j] == 'O')
                        board[i][j] = 'X';
                }
            }
        }
    }
    public void solveBFS(char[][] board) {
        if(board != null && board.length != 0 && board[0].length != 0){
            int rowNum = board.length;
            int colNum = board[0].length;
            // top
            for(int j = 0; j < colNum; j++){
                if(board[0][j] == 'O')
                    BFS(board, 0, j, rowNum, colNum);
                if(board[rowNum - 1][j] == 'O')
                    BFS(board, rowNum - 1, j, rowNum, colNum);
            }
            for(int i = 1; i < rowNum - 1; i++){
                if(board[i][0] == 'O')
                    BFS(board, i, 0, rowNum, colNum);
                if(board[i][colNum - 1] == 'O')
                    BFS(board, i, colNum - 1, rowNum, colNum);
            }
            for(int i = 0; i < rowNum; i++){
                for(int j = 0; j < colNum; j++){
                    if(board[i][j] == '#')
                        board[i][j] = 'O';
                    else if(board[i][j] == 'O')
                        board[i][j] = 'X';
                }
            }
        }
    }
    public void BFS(char[][] board, int row, int col, int rowNum, int colNum){
        LinkedList<Cell> ll = new LinkedList<Cell>();
        board[row][col] = '#';
        ll.offer(new Cell(row, col));
        while(!ll.isEmpty()){
            Cell cell = ll.poll();
            for(int i = 0; i < 4; i ++){
                int neiRow = cell.row + neis[i][0];
                int neiCol = cell.col + neis[i][1];
                if(neiRow >= 0 && neiRow < rowNum && neiCol >= 0 && neiCol < colNum && board[neiRow][neiCol] == 'O'){
                    board[neiRow][neiCol] = '#';
                    ll.offer(new Cell(neiRow, neiCol));
                }
            }
        }
    }    
    public static void main(String[] argvs){
        SurroundedRegions sr = new SurroundedRegions();
        String[] strings = {"OOOO", "OOOO", "OOOO", "OOOO"};
        char[][] board = new char[strings.length][strings[0].length()];
        for(int i = 0; i < strings.length; i++){
            for(int j = 0; j < strings[0].length(); j++){
                board[i][j] = strings[i].charAt(j);
            }
        }
        sr.solve(board);
        for(int i = 0; i < strings.length; i++){
            for(int j = 0; j < strings[0].length(); j++){
                System.out.printf("%c", board[i][j]);
            }
            System.out.println();
        }
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