class Solution {
    public int minimumPushes(String word) {
        int n=word.length();

        int ans=0;

        int whole=n/8;
        int rem=n%8;

        for(int i=1;i<=whole;i++){
            ans+=(8*i);
        }
        ans+=(whole+1)*rem;
        return ans;

    }
}