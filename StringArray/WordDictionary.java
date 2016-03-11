public class WordDictionary{

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            if(cur.children[word.charAt(i) - 'a'] == null)
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word, 0, root);
    }
    private boolean match(String word, int pos, TrieNode cur){
        if(pos == word.length())
            return cur.isLeaf;
        char c = word.charAt(pos);
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(cur.children[i] != null && match(word, pos + 1, cur.children[i]))
                    return true;
            }
            return false;
        } else {
            if(cur.children[c - 'a'] != null)
                return match(word, pos + 1, cur.children[c - 'a']);
            else
                return false;
        }
    }
    public static void main(String[] argvs){
        WordDictionary wd = new WordDictionary();
        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");
        System.out.println(wd.search("a"));
        System.out.println(wd.search(".at"));
        wd.addWord("bat");
        System.out.println(wd.search(".at"));
        System.out.println(wd.search("an."));
        System.out.println(wd.search("a.d."));
        System.out.println(wd.search("b."));
        System.out.println(wd.search("a.d"));
        System.out.println(wd.search("."));
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