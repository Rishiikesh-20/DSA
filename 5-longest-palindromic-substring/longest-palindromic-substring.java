class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();

        // int i=0;
        // int j=0;
        int max=0;
        int max_i=0;
        int max_j=0;
        for(int i=0;i<n;i++){
            int[] odd=expand(i,i,s.toCharArray());
            if(odd[2]>max){
                max=odd[2];
                max_i=odd[0];
                max_j=odd[1];
            }
            if(i+1<n){
                int[] even=expand(i,i+1,s.toCharArray());
                if(even[2]>max){
                    max=even[2];
                    max_i=even[0];
                    max_j=even[1];
                }
            }
        }

        return s.substring(max_i,max_j+1);
    }
    public int[] expand(int i,int j,char[] arr){
        int n=arr.length;
        while(i>=0 && j<n && arr[i]==arr[j]){
            i--;
            j++;
        }
        return new int[]{i+1,j-1,j-i-1};
    }
}