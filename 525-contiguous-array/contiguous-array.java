class Solution {
    public int findMaxLength(int[] nums) {
        /*
        
            0 = 1 , 1 = -1

            1 0 -1 0 -1
            0 1  1  0 1

            1 2 1 0 1
            0 0 1 1 0 1
            0 1 2 3 4 5
          */

        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        map.put(0,-1);
        int max=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                count++;
            }else{
                count--;
            }
            if(map.containsKey(count)){
                max=Math.max(max,i-map.get(count));
            }else{
                map.put(count,i);
            }
        }
        return max;
    }
}