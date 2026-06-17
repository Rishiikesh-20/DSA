class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        recur(candidates,target,0,new ArrayList<>(),result);

        return result;
    }
    public void recur(int[] arr,int target,int i,List<Integer> current,List<List<Integer>> result){
        if(i==arr.length){
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target-arr[i]>=0){
            current.add(arr[i]);
            recur(arr,target-arr[i],i,current,result);
            current.remove(current.size()-1);
        }
        recur(arr,target,i+1,current,result);
    }
}