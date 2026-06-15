class Solution {
    public List<List<Integer>> permuteUnique(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result=new ArrayList<>();
        backTrack(arr,0,result);
        return result;
    }

    public void backTrack(int[] arr,int start,List<List<Integer>> result){
        if(start==arr.length){
            List<Integer> cur=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                cur.add(arr[i]);
            }
            result.add(cur);
            return;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=start;i<arr.length;i++){
            if(set.contains(arr[i])) continue;
            set.add(arr[i]);
            swap(arr,start,i);
            backTrack(arr,start+1,result);
            swap(arr,start,i);
        }
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}