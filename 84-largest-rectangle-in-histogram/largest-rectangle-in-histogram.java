class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int[] NSE=new int[n];
        int[] PSE=new int[n];
        Stack<Integer> stack=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.add(i);
                NSE[i]=n;
            }else{
                NSE[i]=stack.peek();
                stack.add(i);
            }
        }
        stack=new Stack<Integer>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.add(i);
                PSE[i]=-1;
            }else{
                PSE[i]=stack.peek();
                stack.add(i);
            }
        }

        int max=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int len=NSE[i]-PSE[i]-1;
            max=Math.max(arr[i]*len,max);
        }
        return max;
    }
}