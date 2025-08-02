package Leetcode;
import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n=wordList.size();
        int len=beginWord.length();
        HashSet<String> set=new HashSet<>();
        for(String it:wordList){
            set.add(it);
        }
        if(!set.contains(endWord)){
            return 0;
        }

        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            for(int i=0;i<len;i++){
                for(int j=0;j<26;j++){
                    if(i==(len-1)){
                        String temp=pair.s.substring(0,i)+(char)(97+j);
                        if(temp.equals(endWord)){
                            return pair.level+1;
                        }
                        if(set.contains(temp)){
                            queue.add(new Pair(temp,pair.level+1));
                            set.remove(temp);
                        }
                    }else{
                        String temp=pair.s.substring(0,i)+(char)(97+j)+pair.s.substring(i+1,len);
                        if(temp.equals(endWord)){
                            return pair.level+1;
                        }
                        if(set.contains(temp)){
                            queue.add(new Pair(temp,pair.level+1));
                            set.remove(temp);
                        }
                    }
                }
            }
        }

        return 0;
        
    }
}

class Pair{
    String s;
    int level;
    public Pair(String s,int level){
        this.s=s;
        this.level=level;
    }
}