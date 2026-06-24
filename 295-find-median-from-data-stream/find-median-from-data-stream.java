class MedianFinder {
    PriorityQueue<Integer> right;
    PriorityQueue<Integer> left;
    public MedianFinder() {
        this.right=new PriorityQueue<>();
        this.left=new PriorityQueue<>((a,b)->Integer.compare(b,a));
    }
    
    public void addNum(int num) {
       
        left.add(num);
        right.add(left.poll());

        if(right.size()>left.size()){
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size()==right.size()){
            return ((double)left.peek()+right.peek())/2;
        }
        if(left.size() > right.size())
            return left.peek();
        else
            return right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */