public class Trie{
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            if(cur.children[word.charAt(i) - 'a'] == null)
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.isLeaf = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            if(cur.children[word.charAt(i) - 'a'] == null)
                return false;
            cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            if(cur.children[prefix.charAt(i) - 'a'] == null)
                return false;
            cur = cur.children[prefix.charAt(i) - 'a'];
        }
        return true;
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