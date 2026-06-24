class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i=0;i<nums.length;i++){
            list.add(new ArrayList<>());
        }
        for(Integer key:map.keySet()){
            int val=map.get(key);
            list.get(val-1).add(key);
        }

        int[] result=new int[k];
        int cur=n-1;
        while(k>0){
            for(int i=0;i<list.get(cur).size();i++){
                if(k<=0) break;
                result[k-1]=list.get(cur).get(i);
                k--;
            }
           cur--;
        }
        return result;

    }
}