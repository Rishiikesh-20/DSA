class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        ArrayList<Integer> heap=new ArrayList<>();
        for(int i=0;i<n;i++){
            heap.add(nums[i]);
        }
        buildTree(heap);

        int first=-1;
        for(int i=0;i<k-1;i++){
            int last=heap.remove(heap.size()-1);
            if(!heap.isEmpty()) {
                heap.set(0, last);
                heapify(heap, 0);
            }
        }
        return heap.get(0);

    }
    public void heapify(ArrayList<Integer> heap,int i){
        int n=heap.size();
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        
        if(left<n && heap.get(left)>heap.get(largest)){
            largest=left;
        }
        if(right<n && heap.get(right)>heap.get(largest)){
            largest=right;
        }
        if(largest!=i){
            Collections.swap(heap,largest,i);
            heapify(heap,largest);
        }
    }

    public void buildTree(ArrayList<Integer> heap){
        int n=heap.size();
        
        for(int i=n/2-1;i>=0;i--){
            heapify(heap,i);
        }
    }
}