public class WordSearch{
    int[][] neis = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    char[][] board;
    String word;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length <= 0 || board[0].length <= 0)
            return false;
        int rowNum = board.length;
        int colNum = board[0].length;
        if(word == null || word.length() <= 0)
            return true;
        if(word.length() > rowNum * colNum)
            return false;

        this.board = board;
        this.word = word;
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(find(i, j, 0))
                    return true;
            }
        }
        return false;
    }    
    public boolean find(int i, int j, int cur){
        if(board[i][j] == word.charAt(cur)){
            if(cur == word.length() - 1)
                return true;
            char temp = board[i][j];
            board[i][j] = 0;
            boolean result = false;
            for(int k = 0; k < 4; k++){
                int row = i+neis[k][0];
                int col = j+neis[k][1];
                if(row >= 0 && row < board.length && col >= 0 && col < board[0].length 
                    && find(row, col, cur+1)){
                    result = true;
                    break;
                }
            }
            board[i][j] = temp;
            return result;
        }
        return false;
    }
    public static void main(String[] argvs){
        WordSearch ws = new WordSearch();
        String[] strings = {"ABCE", "SFCS", "ADEE"};
        char[][] board = new char[strings.length][strings[0].length()];
        for(int i = 0; i < strings.length; i++){
            for(int j = 0; j < strings[0].length(); j++){
                board[i][j] = strings[i].charAt(j);
            }
        }
        System.out.println(ws.exist(board, "ABCCED"));
        System.out.println(ws.exist(board, "SEE"));
        System.out.println(ws.exist(board, "ABCB"));
    }
}