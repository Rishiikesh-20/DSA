class Solution {
    public String maxValue(String n, int x) {
        StringBuilder sb=new StringBuilder();
        int len=n.length();
        if(n.charAt(0)=='-'){
            sb.append('-');
            n=n.substring(1,len);
            for(int i=0;i<n.length();i++){
                int num=Integer.parseInt(n.charAt(i)+"");

                if(num>x && x!=0){
                    sb.append(x);
                    x=0;
                    sb.append(num);
                }else{
                    sb.append(num);
                }
            }
        }else{
            for(int i=0;i<len;i++){
                int num=Integer.parseInt(n.charAt(i)+"");

                if(num<x){
                    sb.append(x);
                    x=0;
                    sb.append(num);
                }else{
                    sb.append(num);
                }
            }
        }
        if(x!=0){
            sb.append(x);
        }

        return sb.toString();
    }
}