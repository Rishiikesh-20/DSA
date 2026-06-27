class MinStack {
    Stack<Integer> A;
    Stack<Integer> B;
    public MinStack() {
        A=new Stack();
        B=new Stack();
    }
    
    public void push(int value) {
        A.add(value);
        int max=value;
        if(!B.isEmpty())
        max=Math.min(value,B.peek());
        B.add(max);
    }
    
    public void pop() {
        A.pop();
        B.pop();
    }
    
    public int top() {
        return A.peek()==null?-1:A.peek();
    }
    
    public int getMin() {
        return B.peek()==null?-1:B.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */