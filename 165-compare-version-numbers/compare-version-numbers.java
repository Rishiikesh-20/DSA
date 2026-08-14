class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1=version1.split("\\.");
        String[] s2=version2.split("\\.");
        System.out.println("num1: "+s1.length+", num2: "+s2.length);
        int i=0;
        int j=0;

        int n=s1.length;
        int m=s2.length;

        while(i<n && j<m){
            int num1=Integer.parseInt(s1[i]);
            int num2=Integer.parseInt(s2[j]);
            System.out.println("num1: "+num1+", num2: "+num2);
            if(num1<num2){
                return -1;
            }else if(num1>num2){
                return 1;
            }
            i++;
            j++;
        }
        while(i<n){
            int num1=Integer.parseInt(s1[i]);
            if(num1>0){
                return 1;
            }
            i++;
        }
        while(j<m){
            int num2=Integer.parseInt(s2[j]);
            if(num2>0){
                return -1;
            }
            j++;
        }

        return 0;
    }
}