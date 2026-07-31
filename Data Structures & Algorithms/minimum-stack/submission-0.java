class MinStack {

    private Stack<Integer> minStack;
    private Stack<Integer> numStack;

    public MinStack() {
        minStack = new Stack<>();
        numStack = new Stack<>();
    }
    
    public void push(int val) {
        numStack.push(val);
        if(minStack.isEmpty() || val<= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(numStack.isEmpty()) {
            return;
        }
        int top = numStack.pop();
        if(top == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return numStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
