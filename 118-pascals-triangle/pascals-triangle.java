class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            result.add(new ArrayList<>());
            for(int j=0;j<i;j++){
                if(j==0 || j==i-1){
                    result.get(i-1).add(1);
                }else{
                    result.get(i-1).add(result.get(i-2).get(j-1)+result.get(i-2).get(j));
                }
            }
        }
        return result;
    }
}