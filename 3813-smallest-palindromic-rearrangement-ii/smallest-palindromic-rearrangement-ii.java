class Solution {
    public String smallestPalindrome(String s, int k) {
        /*
            abbc

            a--- -> 3!
            b--- -> 3! same b has same thigns 
            b--- -> same

            c--- -> 3!

            total - 4!/2! not more than that 


            we need to divide the k with (n-1)!


            1000
         */

        int[] arr=new int[26];

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }

        int index=-1;
        for(int i=0;i<26;i++){
            if(arr[i]%2==1){
                index=i;
                break;
            }
        }
        int n=s.length();
        int cur=1;
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<n/2;j++){
            boolean found=false;
            for(int i=0;i<26;i++){
                int val=arr[i]/2;
                
                if(val==0) continue;
                int temp=count(arr,i,k,n/2-cur);
                System.out.println("Temp:" + temp);
                
                if(temp<k){
                    k-=temp;
                    if(k<=0){
                        return "";
                    }
                    continue;
                }else{
                    cur++;
                    sb.append((char)('a'+i));
                    arr[i]-=2;
                    found=true;
                    break;
                }
            }
            if(!found){
                return "";
            }
        }
        String temp=sb.toString();

        if(index!=-1){
            sb.append((char)('a'+index));
        }
        sb.append(new StringBuilder(temp).reverse());
        
        return sb.toString();

    }

    public int count(int[] arr,int ind,int k,int len){
        long ans=1;
        for(int i=0;i<26;i++){
            int val=arr[i]/2;
            if(val==0) continue;
            if(ind==i){
                val-=1;
            }
            int temp=Comb(len,val);
            ans*=temp;
            if(ans>1_000_000){
                return 1_000_001;
            }
            
            len-=val;
        }
        return (int)ans;

    }
    public int Comb(int n,int r){
        long ans=1;
        for(int i=1;i<=r;i++){
            ans=ans*(n-r+i)/i;
            if(ans>1_000_000){
                return 1_000_001;
            }
        }
        return (int)ans;
    }


}