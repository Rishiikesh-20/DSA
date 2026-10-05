class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();

        for(String s:wordList){
            set.add(s);
        }

        if(!set.contains(endWord)){
            return 0;
        }

        HashSet<String> visited=new HashSet<>();

        Queue<Pair> queue=new LinkedList<>();

        queue.add(new Pair(beginWord,1));
        visited.add(beginWord);

        while(!queue.isEmpty()){
            Pair node=queue.poll();
            char[] arr=node.s.toCharArray();
            for(int i=0;i<arr.length;i++){
                char temp=arr[i];
                for(int j=0;j<26;j++){
                    arr[i]=(char)(97+j);
                    String x=new String(arr);
                    //System.out.println(x);
                    if(x.equals(endWord)){
                        return node.level+1;
                    }else if(set.contains(x) && !visited.contains(x)){
                        queue.add(new Pair(x,node.level+1));
                        visited.add(x);
                    }
                }
                arr[i]=temp;
            }
        }
        return 0;
    }
}

class Pair{
    String s;
    int level;

    Pair(String s,int level){
        this.s=s;
        this.level=level;
    }
}