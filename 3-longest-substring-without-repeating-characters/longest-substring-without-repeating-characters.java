class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        char[] arr=s.toCharArray();
        int max=0;
        int low=0;
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            char ch=arr[i];
            if(!map.containsKey(ch)){
                map.put(ch,i);
                max=Math.max(max,i-low+1);
                //System.out.println("MAx: "+max+" i: "+i);
            }else{
                while(low<n && map.containsKey(ch)){
                    map.remove(arr[low++]);
                }
                map.put(ch,i);
                max=Math.max(max,i-low+1);
               // System.out.println("MAx: "+max+" i: "+i);
            }
        }
        return max;
    }
}