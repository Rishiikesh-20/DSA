class Solution {
    public int myAtoi(String s) {
        char[] arr=s.toCharArray();
        int n=arr.length;
        int start=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=' ') break;
            start++;
        }
        if(start>=n) return 0;
        int sign=0;
        if(arr[start]=='-'){ sign=1;start++;}else if(arr[start]=='+'){start++;}

        if(start>=n) return 0;

        for(int i=start;i<n;i++){
            if(arr[i]!='0') break;
            start++;
        }
        if(start>=n) return 0;
        long total=0;
        for(int i=start;i<n;i++){
            char ch=arr[i];
            if(Character.isLetter(ch) || ch==' ' || ch=='+' || ch=='-' || ch=='.'){
                break;
            }
            int val=ch-'0';
            total=total*10+val;
            System.out.println(total+" val: "+val);
            if(sign==0 && total>Integer.MAX_VALUE) {return Integer.MAX_VALUE;}
            if(sign==1 && total>2147483648L) {
                 System.out.println("print: "+(int)((Integer.MAX_VALUE-val+1L)/10));
                return Integer.MIN_VALUE;
            }

            
        }
        return sign==1?(int)(-1*total):(int)total;
    }
}