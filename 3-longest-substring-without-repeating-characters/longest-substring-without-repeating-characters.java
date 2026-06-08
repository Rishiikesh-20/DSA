class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        char[] arr=s.toCharArray();

        HashMap<Character,Integer> map=new HashMap<>();

        int low=0;

        int max=0;

        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i])){
                max=Math.max(max,i-low+1);
            }else{
                low=Math.max(low,map.get(arr[i])+1);
                max=Math.max(max,i-low+1);
            }
            map.put(arr[i],i);
        }
        return max;
    }
}