/*
 * A suffix tree made of a set of strings
 * http://www.geeksforgeeks.org/generalized-suffix-tree-1/
 * http://www.geeksforgeeks.org/ukkonens-suffix-tree-construction-part-6/
 * APCFALZ: activePoint change for Active Length Zero
 * APCFWD: activePoint change for walk down
 * APCFER3: activePoint change for extension rule 3
 * APCFER2C1: activePoint change for extension rule 2 (activeNode is root, activeLength greater than 0)
 * APCFER2C2: activePoint change for extension rule 2 (activeNode is not root)
 */
public class GeneralizedSuffixTree{
    class Node{
        int start;
        End end;
        Node[] children;
        int suffixIndex;
        Node suffixLink;
        public Node(int start, End end){
            this.start = start;
            this.end = end;
            initialize();
        }
        private void initialize(){
            this.children = new Node[256];
            this.suffixIndex = -1;
            this.suffixLink = root;
        }
        public int getLength(){
            if(start == -1)
                return 0;
            return end.value - start + 1;
        }
    }
    Node root = null;
    Node lastNewNode;
    Node activeNode;
    int activeLength;
    int activeEdge;
    int remainingSuffixCount;
    End end;

    String s;
    public GeneralizedSuffixTree(String s){
        this.s = s;
        initialize();
        buildSuffixTree();
    }
    private void initialize(){
        end = new End(-1);
        root = this.new Node(-1, end);
        lastNewNode = null;
        activeNode = root;
        activeLength = 0;
        activeEdge = -1;
        remainingSuffixCount = 0;
    }
    private void buildSuffixTree(){
        for(int i = 0; i < s.length(); i++){
            build(i);
        }
        setSuffixIndex(root, 0);
    }
    private void build(int pos){
        // Extension Rule 1
        // Trick 3: one a leaf, always a leaf
        end.value = pos;
        remainingSuffixCount ++;
        lastNewNode = null;
        while(remainingSuffixCount > 0){
            if(activeLength == 0) // APCFALZ
                activeEdge = pos;
            Node next = activeNode.children[s.charAt(activeEdge)];
            if(next == null){
                // Extension Rule 2 
                activeNode.children[s.charAt(activeEdge)] = this.new Node(pos, end);
                // Trick 1: suffix link
                if(lastNewNode != null){
                    lastNewNode.suffixLink = activeNode;
                    lastNewNode = null;
                }
            } else {
                if(walkDown(next)){  // APCFWD
                    continue;
                }
                if(s.charAt(next.start+activeLength) == s.charAt(pos)){
                    // Extension Rule 3
                    activeLength ++;  // APCFER3
                    if(lastNewNode != null){
                        lastNewNode.suffixLink = activeNode;
                        lastNewNode = null;
                    }
                    // Trick 3: stop at Extension Rule 3 
                    break;
                } else {
                    End splitEnd = new End(next.start + activeLength -1);
                    Node split = this.new Node(next.start, splitEnd);
                    activeNode.children[s.charAt(activeEdge)] = split;
                    split.children[s.charAt(pos)] = this.new Node(pos, end);
                    next.start += activeLength;
                    split.children[s.charAt(next.start)] = next;
                    if(lastNewNode != null){
                        lastNewNode.suffixLink = split;
                    }
                    lastNewNode = split;
                }
            }
            remainingSuffixCount --;
            if(activeNode == root && activeLength > 0){ // APCFER2C1
                activeLength --;
                activeEdge = pos - remainingSuffixCount + 1;
            } else if(activeNode != root){ // APCFER2C2
                activeNode = activeNode.suffixLink;
            }
        }
    }
    private boolean walkDown(Node node){
        if(node.getLength() <= activeLength){
            activeNode = node;
            activeEdge += node.getLength();
            activeLength -= node.getLength();
            return true;
        }
        return false;
    }
    private void setSuffixIndex(Node node, int height){
        if(node == null)
            return;
        boolean isLeaf = true;
        for(int i = 0; i < 256; i++){
            if(node.children[i] != null){
                if(isLeaf && node != root){
                    System.out.print(s.substring(node.start, node.end.value + 1));
                    System.out.printf("[%d]\n", node.suffixIndex);
                }
                isLeaf = false;
                setSuffixIndex(node.children[i], height + node.children[i].getLength());
            }
        }
        if(isLeaf){
            for(int i = node.start; i <= node.end.value; i++){
                if(s.charAt(i) == '#'){
                    End newEnd = new End(i);
                    node.end = newEnd;
                    break;
                }
            }
            node.suffixIndex = s.length() - height;
            System.out.print(s.substring(node.start, node.end.value + 1));
            System.out.printf("[%d]\n", node.suffixIndex);
        }
    }
    public static void main(String[] agrvs){
        GeneralizedSuffixTree st = new GeneralizedSuffixTree("xabxa#babxba$");
    }
}
class End{
    int value;
    public End(int value){
        this.value = value;
    }
}