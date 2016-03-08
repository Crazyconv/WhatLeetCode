public class ImplementQueueUsingStacks{
    Stack<Integer> stack = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        if(stack.isEmpty())
            stack.push(x);
        else{
            Stack<Integer> temp = new Stack<Integer>();
            while(!stack.isEmpty())
                temp.push(stack.pop());
            temp.push(x);
            while(!temp.isEmpty())
                stack.push(temp.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }    
}