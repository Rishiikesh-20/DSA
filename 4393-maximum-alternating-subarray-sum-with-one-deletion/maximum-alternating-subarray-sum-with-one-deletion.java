class Solution {
    public long maxAlternatingSum(int[] nums) {
        long neg=Long.MIN_VALUE/2;
        long end=neg;
        long ond=neg;
        long ed=neg;
        long od=neg;

        int n=nums.length;
        long result=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            int x=nums[i];
            
            long temp1=end;
            long temp2=ond;
            long temp3=ed;
            long temp4=od;


            end=Math.max(temp2+x,x);
            ond=temp1-x;
            ed=Math.max(temp1,temp4+x);
            od=Math.max(temp2,temp3-x);
            result=Math.max(result,Math.max(Math.max(end,ond),Math.max(ed,od)));
        }
        return result;
    }
}