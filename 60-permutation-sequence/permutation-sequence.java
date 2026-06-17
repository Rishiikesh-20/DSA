class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial=new int[n+1];
        factorial[0]=1;
        List<Character> numbers=new ArrayList<>();
        for(int i=1;i<=n;i++){
            factorial[i]=factorial[i-1]*i;
            numbers.add((char)(i+'0'));
        }
        StringBuilder s=new StringBuilder();
        recur(n,k-1,s,numbers,factorial);
        return s.toString();
    }

    public void recur(int n,int k,StringBuilder s,List<Character> numbers,int[] factorial){
        if(numbers.size()==0){
            return;
        }
        int blockSize=factorial[numbers.size()-1];
        
        int ind=k/blockSize;

        s.append(numbers.get(ind));
        numbers.remove(ind);

        recur(n,k%blockSize,s,numbers,factorial);
    }
}