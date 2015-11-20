/*
 * http://www.geeksforgeeks.org/trie-insert-and-search/
 * http://www.geeksforgeeks.org/trie-delete/
 */
public class Trie{
    int count;
    Node root;
    public Trie(){
        count = 0;
        root = new Node();
    }

    // O(n)
    public void insert(String s){
        count ++;
        Node node = root;
        for(int i = 0; i < s.length(); i++){
            if(node.children[s.charAt(i)] == null){
                node.children[s.charAt(i)] = new Node();
            }
            node = node.children[s.charAt(i)];
        }
        node.value = count;
    }

    // O(n)
    public boolean search(String s){
        Node node = root;
        for(int i = 0; i < s.length(); i++){
            if(node.children[s.charAt(i)] == null){
                return false;
            }
            node = node.children[s.charAt(i)];
        }
        return node.value != 0;
    }

    // O(n)
    public void delete(String s){
        deleteHelper(root, s, -1);
    }
    // result indicates whether the node can be delete
    public boolean deleteHelper(Node node, String s, int cur){
        if(node != null){
            if(cur == s.length() - 1){ // end of s
                if(isLeaf(node) && !hasChildren(node))
                    return true;
                else
                    node.value = 0;
            } else {
                if(deleteHelper(node.children[s.charAt(cur+1)], s, cur+1)){
                    node.children[s.charAt(cur+1)] = null;
                    if(!isLeaf(node) && !hasChildren(node)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isLeaf(Node node){
        return node.value != 0;
    }
    public boolean hasChildren(Node node){
        for(int i = 0; i < 256; i ++){
            if(node.children[i] != null)
                return true;
        }
        return false;
    }

    public static void main(String[] argvs){
        Trie trie = new Trie();
        String[] s = {"she", "sells", "sea", "shore", "the", "by", "sheer"};
        for(int i = 0; i < s.length; i ++){
            trie.insert(s[i]);
        }
        trie.delete("the");
        trie.delete("sea");
        trie.delete("she");
        for(int i = 0; i < s.length; i++){
            String result = null;
            if(trie.search(s[i])){
                result = " in ";
            } else {
                result = " not in ";
            }
            System.out.println(s[i] + result + "trie");
        }
    }
}
class Node{
    int value;
    Node[] children;
    public Node(){
        value = 0;
        children = new Node[256];
    }
}