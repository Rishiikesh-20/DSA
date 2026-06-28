class StockSpanner {
    Stack<Integer> stack;
    Stack<Integer> lastFreq;
    public StockSpanner() {
        stack=new Stack<>();
        lastFreq=new Stack<>();
    }
    
    public int next(int price) {
        if(stack.isEmpty()){
            stack.add(price);
            lastFreq.add(1);
            System.out.println(lastFreq);
            return 1;
        }else{
            if(stack.peek()>price){
                lastFreq.add(1);
                stack.add(price);
                System.out.println(lastFreq);
                return 1;
            }
            //int max=Integer.MIN_VALUE;
            int count=0;
            while(!stack.isEmpty() && stack.peek()<=price){
                //max=Math.max(max,lastFreq.peek());
                stack.pop();
                count+=lastFreq.pop();;
            }
            stack.add(price);
            // int val=count+max;
            lastFreq.add(count+1);
            System.out.println(lastFreq);
            return count+1;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */