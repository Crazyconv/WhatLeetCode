import java.util.Stack;
public class MinStack{
    // store the gap between the min and the current value

    Stack<Long> s = new Stack<Long>();
    long min;
    public void push(int x) {
        if(s.isEmpty()){
            s.push(0L);
            min = x;
        } else {
            s.push(x - min); // may be negative if x is smaller than min
            if(x < min)
                min = x;
        }
    }

    public void pop() {
        if(!s.isEmpty()){
            long pop = s.pop();
            if(pop < 0)
                min = min - pop;
        }
    }

    public int top() {
        long top = s.peek();
        if(top > 0)
            return (int)(top + min);
        else
            return (int)min;
    }

    public int getMin() {
        return (int)min;
    } 

    // push the min to stack
    Stack<Integer> s = new Stack<Integer>();
    int min;
    public void push(int x) {
        if(s.isEmpty()){
            s.push(x);
            s.push(x);
            min = x;
        } else {
            if(x <= min){
                s.push(min);
                min = x;
            }
            s.push(x);
        }
    }

    public void pop() {
        if(!s.isEmpty()){
            int pop = s.pop();
            if(pop == min)
                min = s.pop();
        }
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }        
}