class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        /*
            subarray/k
            (sum-x)%k => sum%k -x%k =0

            knownRem - mapRem =0 
        */

        int n =nums.length;

        HashMap<Integer,Integer> map=new HashMap<>();

        map.put(0,1);
        int count=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int rem=(sum%k+k)%k;

            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
            map.putIfAbsent(rem,0);
            map.put(rem,map.get(rem)+1);
        }
        return count;
    }
}