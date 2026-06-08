class Solution {
    public int longestConsecutive(int[] arr) {
        HashSet<Integer> set=new HashSet<>();

        int n=arr.length;


        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        int result=0;
        for(int num : set){
            if(num!=Integer.MIN_VALUE && !set.contains(num-1)){
                int count=1;
                int val=num;
                while(num!=Integer.MAX_VALUE && set.contains(val+1)){
                    count++;
                    val++;
                }
                result=Math.max(result,count);
            }
        }
        return result;
    }
}