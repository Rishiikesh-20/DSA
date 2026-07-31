class Solution {
    public int minimumPushes(String word) {
        int[] arr=new int[26];

        for(int i=0;i<word.length();i++){
            arr[word.charAt(i)-'a']++;
        }
        PriorityQueue<Pair> queue=new PriorityQueue<>((a,b)->(b.count-a.count));
        for(int i=0;i<26;i++){
            if(arr[i]>0){
                queue.add(new Pair(i,arr[i])); 
            }
        }
        int ans=0;
        int count=0;
        int cur=1;
        while(!queue.isEmpty()){
            Pair p=queue.poll();
            count++;
            if(count==9){
                count=1;
                cur++;
            }
            ans+=(p.count*cur);
        }

        return ans;
    }
}

class Pair{
    int val;
    int count;
    Pair(int val,int count){
        this.val=val;
        this.count=count;
    }
}