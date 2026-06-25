class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();

        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums1.length;
        int m=nums2.length;

        for(int i=0;i<n;i++){
            map.put(nums1[i],i);
        }
        int[] result=new int[n];
        for(int i=m-1;i>=0;i--){
            if(map.containsKey(nums2[i])){
                while(!stack.isEmpty() && stack.peek()<nums2[i]){
                    stack.pop();
                }
                if(stack.size()==0)result[map.get(nums2[i])]=-1;
                else result[map.get(nums2[i])]=stack.peek();
            }
            stack.add(nums2[i]);
        }
        return result;
    }
}