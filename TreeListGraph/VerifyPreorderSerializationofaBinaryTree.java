import java.util.Stack;
public class VerifyPreorderSerializationofaBinaryTree{
    // maintain a stack of unfull nodes
    public boolean isValidSerialization(String preorder) {
        Stack<Wrap> s = new Stack<Wrap>();
        if(preorder != null){
            String[] nodes = preorder.split(",");
            if(nodes.length > 0){
                if(nodes[0].equals("#"))
                    return nodes.length == 1;
                s.push(new Wrap(2));
                for(int i = 1; i < nodes.length; i++){
                    if(nodes[i].equals("#")){
                        while(!s.isEmpty() && s.peek().remain == 1){
                            s.pop();
                        }
                        if(s.isEmpty())
                            return i == nodes.length - 1;
                        s.peek().remain--;
                    } else {
                        s.push(new Wrap(2));
                    }
                }
            }
        }
        return s.size() == 0;
    }

    // stack
    public boolean isValidSerialization(String preorder) {
        if(preorder != null){
            String[] nodes = preorder.split(",");
            if(nodes.length > 0){
                Stack<String> s = new Stack<String>();
                for(String str: nodes){
                    if(str.equals("#")){
                        while(!s.isEmpty() && s.peek().equals("#")){
                            s.pop();
                            if(s.isEmpty())
                                return false;
                            s.pop();
                        }
                    }
                    s.push(str);
                }
                return s.size() == 1 && s.peek().equals("#");
            }
        }
        return true;
    }    

    // diff = outdegree - indegree
    // when a node comes, diff --; if non null, diff += 2
    // diff can never smaller than 0, final result should be 0;
    public boolean isValidSerialization(String preorder){
        if(preorder != null){
            String[] nodes = preorder.split(",");
            if(nodes.length > 0){
                int diff = 1;
                for(String str: nodes){
                    if(--diff < 0)
                        return false;
                    if(!str.equals("#"))
                        diff += 2;
                }
                return diff == 0;
            }
        }
        return true;
    }

    // nullCnt == nodeCnt + 1
    public boolean isValidSerialization(String preorder){
        if(preorder != null){
            String[] nodes = preorder.split(",");
            if(nodes.length > 0){
                int nullCnt = 0, nodeCnt = 0;
                for(int i = 0; i < nodes.length; i++){
                    String str = nodes[i];
                    if(str.equals("#"))
                        nullCnt ++;
                    else
                        nodeCnt ++;
                    if(nullCnt - nodeCnt > 1 || (nullCnt - nodeCnt == 1 && i != nodes.length - 1))
                        return false;
                }
                return nullCnt - nodeCnt == 1;
            }
        }
        return true;        
    }    
}
class Wrap{
    int remain;
    Wrap(int i){ remain = i;}
}