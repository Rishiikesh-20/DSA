class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        recur(s,0,0,new ArrayList<>(),result);
        return result;
    }

    public void recur(String s,int i,int j,List<String> current,List<List<String>> result){
        if(i==s.length() && j==s.length()){
            result.add(new ArrayList<>(current));
            return;
        }else if(j==s.length()){
            return;
        }
        if(palindrome(s.substring(i,j+1))){
            current.add(s.substring(i,j+1));
            recur(s,j+1,j+1,current,result);
            current.remove(current.size()-1);
        }
        recur(s,i,j+1,current,result);
    }
    public boolean palindrome(String s){
        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}