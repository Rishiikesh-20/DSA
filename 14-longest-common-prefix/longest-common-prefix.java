class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,strs[i].length());
        }
        StringBuilder s=new StringBuilder();
        for(int i=0;i<min;i++){
            int flag=0;
            char ch=strs[0].charAt(i);
            for(int j=1;j<n;j++){
                if(ch!=strs[j].charAt(i)){
                    flag=1;
                    break;
                }
            }
            if(flag==1) break;
            s.append(ch);
        }
        return s.toString();
    }
}