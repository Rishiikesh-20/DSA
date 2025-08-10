package Leetcode;
import java.util.*;
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,0);
            } 
            map.put(ch,map.get(ch)+1);
        }
        ArrayList<Pair> arr=new ArrayList<>();

        for(var entry:map.entrySet()){
            arr.add(new Pair(entry.getKey(),entry.getValue()));
        }

        Collections.sort(arr,new Comparator<Pair>(){
            @Override
            public int compare(Pair a,Pair b){
                return b.count-a.count;
            }
        });
        String result="";
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<arr.get(i).count;j++){
                result=result+arr.get(i).ch;
            }
        }

        return result;
    }
}
class Pair{
    char ch;
    int count;
    public Pair(char ch,int count){
        this.ch=ch;
        this.count=count;
    }
}
