package Leetcode;
import java.util.Comparator;
import java.util.TreeMap;

class Solution {
    public String majorityFrequencyGroup(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-97]++;
        }
        TreeMap<Integer,String> hash=new TreeMap<>(Comparator.reverseOrder());
        for(int i=0;i<26;i++){
            if(arr[i]==0) continue;
            if(!hash.containsKey(arr[i])){
                hash.put(arr[i],"");
            }
            String freq=hash.get(arr[i])+(char)(97+i);
            hash.put(arr[i],freq);
        }
        int maxLength=Integer.MIN_VALUE;
        int chooseFreq=0;
        for(Integer i:hash.keySet()){
            if(maxLength<hash.get(i).length()){
                maxLength=hash.get(i).length();
                chooseFreq=i;
            }
        }
        return hash.get(chooseFreq);
    }
}