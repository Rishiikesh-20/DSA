class Solution {
    public String smallestPalindrome(String s) {
        int[] arr=new int[26];

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }

        StringBuilder sb=new StringBuilder();
        int one=-1;
        for(int i=0;i<26;i++){
            int val=arr[i]/2;
            if(arr[i]%2==1){ one=i;arr[i]--;}
            arr[i]-=val;
            while(val>0){
                sb.append((char)('a'+i));
                val--;
            }
        }

        if(one!=-1) sb.append((char)('a'+one));
            
       
        for(int i=25;i>=0;i--){
            while(arr[i]>0){
                sb.append((char)('a'+i));
                arr[i]--;
            }
        }
        

        return sb.toString();

    }
}