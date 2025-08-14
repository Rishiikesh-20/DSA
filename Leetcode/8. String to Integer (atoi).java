package Leetcode;

class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        int sign=0;
        int flag=0;
        String answer="";
        int j=-1;
        if(s.length()==0){
            return 0;
        }
        int i=0;
        while(i<s.length() && s.charAt(i)==' '){
                i++;
        }
        for(;i<n;i++){
            
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                flag=1;
                if(j==-1 && ch=='0') {
                    continue;
                }
                j=1;
                answer=answer+ch;
            }else if(ch=='-'  && flag==0){
                sign=1;
                flag=1;

            }else if(ch=='+' && flag==0){
                flag=1;
            }else{
                
                break;
            }
        }
        if(answer.length()==0){
            answer=answer+'0';
        }

        int temp=Integer.MAX_VALUE;
        int tempMinus=Integer.MIN_VALUE;

        if(answer.length()>10){
            if(sign==1){
                return tempMinus;
            }
            return temp;
        }

        long cur=Long.parseLong(answer);
        
        if(sign==1){
            if(tempMinus+cur>0){
                return tempMinus;
            }
            return (int)(-1*cur);
        }else{
            if(temp-cur<0){
                return temp;
            }
            return (int)cur;
        }

    }
}
