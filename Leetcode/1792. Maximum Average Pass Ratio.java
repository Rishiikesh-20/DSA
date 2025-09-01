package Leetcode;
import java.util.*;
public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n=classes.length;
        PriorityQueue<Pair> maxHeap=new PriorityQueue<>((a,b)->Double.compare(b.gain,a.gain));
        for(int i=0;i<n;i++){
            maxHeap.add(new Pair(classes[i][0],classes[i][1]));
        }
        for(int i=0;i<extraStudents;i++){
            Pair value=maxHeap.poll();
            maxHeap.add(new Pair(value.p+1,value.total+1));
        }
        double sum=0.0;
        while(!maxHeap.isEmpty()){
            Pair value=maxHeap.poll();
            sum+=(double)value.p/value.total;
        }
        sum=sum/(double)n;
        return Math.round(sum*100000.0)/100000.0;
    }
}

class Pair{
    int p;
    int total;
    double gain;
    Pair(int p,int total){
        this.p=p;
        this.total=total;
        this.gain=(double)(p+1)/(total+1)-(double)(p)/total;
    }
} {
    
}
