import java.util.LinkedList;
public class ImplementStackUsingQueues{
    LinkedList<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        if(queue.isEmpty())
            queue.offer(x);
        else{
            LinkedList<Integer> resultQueue = new LinkedList<Integer>();
            resultQueue.offer(x);
            while(!queue.isEmpty())
                resultQueue.offer(queue.pop());
            queue = resultQueue;
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }    
}