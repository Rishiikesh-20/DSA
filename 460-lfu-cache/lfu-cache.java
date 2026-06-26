class LFUCache {
    HashMap<Integer,Node> map;
    HashMap<Integer,Node[]> freq;
    int min;
    int capacity;
    public LFUCache(int capacity) {
        this.map=new HashMap<>();
        this.freq=new HashMap<>();
        this.min=Integer.MAX_VALUE;
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp=map.get(key);
            if(temp.next.next==null && temp.prev.prev==null){
                freq.remove(temp.freq);
                if(min==temp.freq){
                    min=temp.freq+1;
                }
            }else{
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
            }
            int newFreq=temp.freq+1;
            if(!freq.containsKey(newFreq)){
                Node head=new Node(-1,-1);
                Node tail=new Node(-1,-1);
                head.next=tail;
                tail.prev=head;
                freq.put(newFreq,new Node[]{head,tail});
            }
            Node node=freq.get(newFreq)[0];
            temp.prev=node;
            temp.next=node.next;
            node.next.prev=temp;
            node.next=temp;

            temp.freq=newFreq;
            return temp.val;
        }else{
            return -1;
        }

    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            Node temp=map.get(key);
            if(temp.next.next==null && temp.prev.prev==null){
                freq.remove(temp.freq);
                if(min==temp.freq){
                    min=temp.freq+1;
                }
            }else{
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
            }
            int newFreq=temp.freq+1;
            if(!freq.containsKey(newFreq)){
                Node head=new Node(-1,-1);
                Node tail=new Node(-1,-1);
                head.next=tail;
                tail.prev=head;
                freq.put(newFreq,new Node[]{head,tail});
            }
            Node node=freq.get(newFreq)[0];
            temp.prev=node;
            temp.next=node.next;
            node.next.prev=temp;
            node.next=temp;

            temp.freq=newFreq;
            temp.val=value;
            return;
        }

        if(map.size()==capacity){
            Node node=freq.get(min)[1];
            Node temp=node.prev;
            if(temp.next.next==null && temp.prev.prev==null){
                freq.remove(temp.freq);
                if(min==temp.freq){
                    min=temp.freq+1;
                }
            }else{
                node.prev=node.prev.prev;
                node.prev.next=node;
            }
            map.remove(temp.key); 
        }

        if(!freq.containsKey(1)){
            Node head=new Node(-1,-1);
            Node tail=new Node(-1,-1);
            head.next=tail;
            tail.prev=head;
            freq.put(1,new Node[]{head,tail});  
        }
        min=1;

        Node temp=new Node(key,value);
        
        Node node=freq.get(1)[0];
        temp.prev=node;
        temp.next=node.next;
        node.next.prev=temp;
        node.next=temp;

        temp.freq = 1; 
        map.put(key, temp);
    }
}

class Node{
    int key;
    int val;
    Node prev;
    Node next;
    int freq;
    Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */