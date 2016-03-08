import java.util.Stack;
public class VerifyPreorderSequenceinBinarySearchTree{
    // stack method
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> s = new Stack<Integer>();
        int last = Integer.MIN_VALUE;
        for(int i = 0; i < preorder.length; i++){
            if(preorder[i] < last)
                return false;
            while(!s.isEmpty() && s.peek() < preorder[i]){
                last = s.pop();
            }
            s.push(preorder[i]);
        }
        return true;
    } 
    // use index
    public boolean verifyPreorder(int[] preorder) {
        int last = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i < preorder.length; i++){
            if(preorder[i] < last)
                return false;
            while(index >= 0 && preorder[index] < preorder[i]){
                last = preorder[index--];
            }
            preorder[++index] = preorder[i];
        }
        return true;
    }        
}