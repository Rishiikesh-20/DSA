package Leetcode;


class Solution1 {
    public int myAtoi(String s) {
        int[] sign=new int[1];
        sign[0]=-1;
        String result=recur(s,0,0,0,sign);
        if(result.length()==0){
            return 0;
        }
        if(sign[0]==0){
            return Integer.parseInt(result);
        }else{
            if(Long.parseLong(result)+Integer.MIN_VALUE==0){
                return Integer.MIN_VALUE;
            }
            return -1*Integer.parseInt(result);
        }
    }

    public static String recur(String s,int i,int flag,int count,int[] sign){
        if(i>=s.length() || (flag==1 && (s.charAt(i)=='-' || s.charAt(i)=='+'))){
            return "";
        }

        if(s.charAt(i)==' ' && sign[0]==-1){
            return recur(s,i+1,flag,count,sign);
        }

        if(flag==0 && sign[0]==-1 && (s.charAt(i)=='-' || s.charAt(i)=='+')){
            sign[0]=s.charAt(i)=='-'?1:0;
            return recur(s,i+1,flag,count,sign);
        }
        if(!Character.isDigit(s.charAt(i))){
            return "";
        }else if(s.charAt(i)=='0' && flag==0){
            if(sign[0]==-1){
                sign[0]=0;
            }
            return recur(s,i+1,flag,count,sign);
        }
        flag=1;
        count++;
        if(sign[0]==-1){
            sign[0]=0;
        }
        if(count>10){
            return sign[0]==1?""+Integer.MIN_VALUE:""+Integer.MAX_VALUE;
        }
        String result=recur(s,i+1,flag,count,sign);
        if(result.equals(""+Integer.MIN_VALUE) || result.equals( ""+Integer.MAX_VALUE)){
            return result;
        }
        Long num=Long.parseLong(s.charAt(i)+result);
        if(sign[0]==1){
            if(Integer.MIN_VALUE+num>0){
                return ""+Integer.MIN_VALUE;
            }else{
                return s.charAt(i)+result;
            }
        }else  if(sign[0]==0){
             if(num-Integer.MAX_VALUE>0){
                return ""+Integer.MAX_VALUE;
            }else{
                return s.charAt(i)+result;
            }
        }
        return "";
    }
}

// Iterative Solution
class Solution2 {
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
