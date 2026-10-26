class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*10^4 * 10^2 log10^2= 10^4 *2*10^2 = 10^6*2 
        */
        int n=strs.length;
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char[] arr=strs[i].toCharArray();
            Arrays.sort(arr);
            String temp=new String(arr);
            map.putIfAbsent(temp,new ArrayList<>());
            map.get(temp).add(strs[i]);
        }

        List<List<String>> result=new ArrayList<>();

        for(List<String> list:map.values()){
            result.add(list);
        }
        return result;
    }
}