class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        /*
            servers -> weight priority , then index - priorityQueue
            busy servers -> finishTime priority , then weight , then index
        */

        int n=tasks.length;

        PriorityQueue<Server> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.weight==b.weight){
                    return Integer.compare(a.index,b.index);
                }
                return Integer.compare(a.weight,b.weight);
            }
        );

        PriorityQueue<Server> busyServer=new PriorityQueue<>(
            (a,b)->{
                if(a.freeTime!=b.freeTime){
                    return Integer.compare(a.freeTime,b.freeTime);
                }else{
                    if(a.weight==b.weight){
                        return Integer.compare(a.index,b.index);
                    }
                    return Integer.compare(a.weight,b.weight);
                }
            }
        );

        
        for(int i=0;i<servers.length;i++){
            pq.add(new Server(servers[i],i,0));
        }
        
        
        int j=0;
        int[] ans=new int[n];
        while(j<n){
            while(!busyServer.isEmpty() && busyServer.peek().freeTime<=j){
                pq.add(busyServer.poll());
            }

            if(pq.isEmpty()){
                Server node=busyServer.poll();
                ans[j]=node.index;
                busyServer.add(new Server(node.weight,node.index,node.freeTime+tasks[j]));
                j++;
                continue;
            }
            
           
            int taskTime=tasks[j];
            Server serverAvail=pq.poll();
            ans[j]=serverAvail.index;
            busyServer.add(new Server(serverAvail.weight,serverAvail.index,j+taskTime));
            j++;
            
        }

        return ans;

    }
}

class Server{
    int weight;
    int index;
    int freeTime;

    Server(int weight,int index,int freeTime){
        this.weight=weight;
        this.index=index;
        this.freeTime=freeTime;
    }
}