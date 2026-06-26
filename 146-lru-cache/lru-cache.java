class LRUCache {
    Node head;
    Node tail;
    HashMap<Integer,Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        map=new HashMap<>();
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node temp=map.get(key);
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
        temp.prev=head;
        temp.next=head.next;
        head.next.prev=temp;
        head.next=temp;

        return temp.val;
    }
    
    public void put(int key, int value) {
         if(map.containsKey(key)){
            Node old = map.get(key);
            old.val = value;
            old.prev.next = old.next;
            old.next.prev = old.prev;
            old.next = head.next;
            old.prev = head;
            head.next.prev = old;
            head.next = old;
            return;
        }
        if(map.size()==capacity){
            Node rem=tail.prev;
            tail.prev=rem.prev;
            rem.prev.next=tail;
            map.remove(rem.key);
        }
        Node temp=new Node(key,value);
       
        map.put(key,temp);
        temp.next=head.next;
        temp.prev=head;
        head.next.prev=temp;
        head.next=temp;

    }
}


class Node{
    int key;
    int val;
    Node prev;
    Node next;

    Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */