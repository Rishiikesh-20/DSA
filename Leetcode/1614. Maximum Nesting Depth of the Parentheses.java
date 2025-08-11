package Leetcode;

class Solution {
    public int maxDepth(String s) {
        int maxCount=0;
        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                count+=1;
                maxCount=Math.max(count,maxCount);
            }else if(s.charAt(i)==')'){
                count-=1;
            }
        }
        return maxCount;
    }
}
