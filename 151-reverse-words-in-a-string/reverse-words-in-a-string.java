class Solution {
    public String reverseWords(String s) {
        char[] arr=s.toCharArray();
        int n=arr.length;
        reverse(arr,0,n-1);

        int start=0;
        while(start<n){
            while(start<n && arr[start]==' '){
                start++;
            }
            if(start>=n) break;

            int end=start;
            while(end<n && arr[end]!=' '){
                end++;
            }
            reverse(arr,start,end-1);
            start=end;
        }

        int i=0;
        int j=0;

        while(j<n){
            while(j<n && arr[j]==' '){
                j++;
            }
            if(j>=n) break;

            while(j<n && arr[j]!=' '){
                arr[i++]=arr[j++];
            }
            while(j<n && arr[j]==' '){
                j++;
            }
            if(j<n)
                arr[i++]=' ';
        }
        return new String(arr,0,i);

    }
    public void reverse(char[] arr,int l,int r){
        while(l<r){
            char temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
}