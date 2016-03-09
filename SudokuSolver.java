// other methods:
// https://leetcode.com/discuss/21452/sharing-my-2ms-c-solution-with-comments-and-explanations
// https://leetcode.com/discuss/34552/singapore-prime-minister-hsien-loongs-sudoku-solver-code-runs
// ideas: bit mask instead of set
//        start from the cells with least possibilities

import java.util.*;
public class SudokuSolver{
    public void solveSudoku(char[][] board) {
        ArrayList<HashSet<Character>> h = new ArrayList<HashSet<Character>>(9);
        ArrayList<HashSet<Character>> v = new ArrayList<HashSet<Character>>(9);
        ArrayList<HashSet<Character>> s = new ArrayList<HashSet<Character>>(9);
        for(int i = 0; i < 9; i ++){
            h.add(new HashSet<Character>());
            v.add(new HashSet<Character>());
            s.add(new HashSet<Character>());
        }
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    h.get(i).add(board[i][j]);
                    v.get(j).add(board[i][j]);
                    s.get((i/3)*3+j/3).add(board[i][j]);
                }
            }
        }
        solve(board, 0, 0, h, v, s);
    }    

    public boolean solve(char[][] board, int i, int j, ArrayList<HashSet<Character>> h,
        ArrayList<HashSet<Character>> v, ArrayList<HashSet<Character>> s){

        if(i == 9)
            return true;

        int nextI = (j == 8)? (i + 1): i;
        int nextJ = (j + 1) % 9;
        if(board[i][j] != '.')
            return solve(board, nextI, nextJ, h, v, s);
        else{
            int sIndex = (i / 3) * 3 + j / 3;
            for(char num = '1'; num <= '9'; num++){
                if(!h.get(i).contains(num) && !v.get(j).contains(num) && !s.get(sIndex).contains(num)){
                    h.get(i).add(num);
                    v.get(j).add(num);
                    s.get(sIndex).add(num);
                    board[i][j] = num;
                    System.out.printf("%d %d %c\n", i, j, num);
                    if(solve(board, nextI, nextJ, h, v, s))
                        return true;
                    h.get(i).remove(num);
                    v.get(j).remove(num);
                    s.get(sIndex).remove(num);
                }
            }
            board[i][j] = '.';
            return false;
        }
    }
    public static void main(String[] argvs){
        char[][] board = {{'.','.','9','7','4','8','.','.','.'},
                          {'7','.','.','.','.','.','.','.','.'},
                          {'.','2','.','1','.','9','.','.','.'},
                          {'.','.','7','.','.','.','2','4','.'},
                          {'.','6','4','.','1','.','5','9','.'},
                          {'.','9','8','.','.','.','3','.','.'},
                          {'.','.','.','8','.','3','.','2','.'},
                          {'.','.','.','.','.','.','.','.','6'},
                          {'.','.','.','2','7','5','9','.','.'}};
        SudokuSolver ss = new SudokuSolver();
        ss.solveSudoku(board);
    }
}