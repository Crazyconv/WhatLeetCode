import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
public class WordSearchII{
    public static final int[][] neis = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    HashSet<String> results;
    char[][] board;
    String[] words;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
        this.results = new HashSet<String>();
        if(board != null && board.length != 0 && board[0].length != 0 && words != null && words.length != 0){
            Trie trie = new Trie();
            for(int i = 0; i < words.length; i++){
                trie.insert(words[i]);
            }
            for(int i = 0; i < board.length; i ++){
                for(int j = 0; j < board[0].length; j++){
                    find(i, j, trie.root, "");
                }
            }
        }

        ArrayList<String> al = new ArrayList<String>();
        for(String result: results){
            al.add(result);
        }
        return al;
    }    
    public void find(int i, int j, TrieNode cur, String s){
        if(board[i][j] != 0){
            cur = cur.children[board[i][j]-'a'];
            if(cur != null){
                String next = s + String.valueOf(board[i][j]);
                if(cur.isLeaf)
                    results.add(next);

                char temp = board[i][j];
                board[i][j] = 0;
                for(int k = 0; k < 4; k++){
                    int row = i+neis[k][0];
                    int col = j+neis[k][1];
                    if(row >= 0 && row < board.length && col >= 0 && col < board[0].length){
                        find(row, col, cur, next);
                    }
                }
                board[i][j] = temp;
            }
        }
    }
}
class TrieNode {
    // Initialize your data structure here.
    boolean isLeaf;
    TrieNode[] children;
    public TrieNode() {
        isLeaf = false;
        children = new TrieNode[26];
    }
}
class Trie{
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            if(cur.children[word.charAt(i) - 'a'] == null)
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.isLeaf = true;
    }  
}