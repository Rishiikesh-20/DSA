class Solution {
    public int findGCD(int[] arr) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        int n=arr.length;

        for(int i=0;i<n;i++){
            if(min>arr[i]){
                min=arr[i];
            }
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return gcd(min,max);
    }
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}