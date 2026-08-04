class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int small=Integer.MAX_VALUE;
        int big=Integer.MIN_VALUE;
        for(int num:nums){
            set.add(num);
            small=Math.min(small,num);
            big=Math.max(big,num);
        }
        List<Integer> list=new ArrayList<>();
        for(int i=small;i<=big;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}