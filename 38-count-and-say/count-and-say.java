class Solution {
    public String countAndSay(int n) {
        String s="1";

        for(int i=2;i<=n;i++){
            s=helper(s);
        }
        return s;
    }
    String helper(String s){
        int cur=Integer.parseInt(s.charAt(0)+"");
        int count=1;
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=1;i<s.length();i++){
            int val=Integer.parseInt(s.charAt(i)+"");
            if(val==cur){
                count++;
            }else{
                list.add(new int[]{count,cur});
                cur=val;
                count=1;
            }
        }
        list.add(new int[]{count,cur});
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)[0]+""+list.get(i)[1]);
        }
        System.out.println("S: "+sb.toString());
        return sb.toString();
    }
}