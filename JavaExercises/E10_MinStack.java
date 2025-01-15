public class E10_MinStack {
    private java.util.Stack<Integer> stack;
    private java.util.Stack<Integer> minStack;
    
    public E10_MinStack() {
        stack = new java.util.Stack<>();
        minStack = new java.util.Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}