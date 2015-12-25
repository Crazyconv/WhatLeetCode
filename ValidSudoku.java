import java.util.HashSet;
public class ValidSudoku{
    public boolean isValidSudoku(char[][] board) {
        if(board != null && board.length == 9 && board[0].length == 9){
            for(int i = 0; i < 9; i++){
                HashSet<Character> nums = new HashSet<Character>();
                for(int j = 0; j < 9; j++){
                    if(board[i][j] != '.'){
                        if(nums.contains(board[i][j]))
                            return false;
                        else
                            nums.add(board[i][j]);
                    }
                }
            }
            for(int j = 0; j < 9; j++){
                HashSet<Character> nums = new HashSet<Character>();
                for(int i = 0; i < 9; i++){
                    if(board[i][j] != '.'){
                        if(nums.contains(board[i][j]))
                            return false;
                        else
                            nums.add(board[i][j]);
                    }
                }
            }
            for(int k = 0; k < 3; k++){
                for(int m = 0; m < 3; m++){
                    HashSet<Character> nums = new HashSet<Character>();
                    for(int i = 3*k; i < 3*k+3; i++){
                        for(int j = 3*m; j < 3*m+3; j++){
                            if(board[i][j] != '.'){
                                if(nums.contains(board[i][j]))
                                    return false;
                                else
                                    nums.add(board[i][j]);
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }    
}