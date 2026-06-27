class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n=arr.length;
        Node head=new Node(-1);
        Node tail=new Node(-1);

        head.next=tail;
        tail.prev=head;

        int[] result=new int[n-k+1];
        for(int i=0;i<k;i++){
            while(tail.prev.val!=-1 && arr[tail.prev.val]<=arr[i]){
                tail.prev.prev.next=tail;
                tail.prev=tail.prev.prev;
            }
            Node temp=new Node(i);
            temp.prev=tail.prev;
            temp.next=tail;
            temp.prev.next=temp;
            tail.prev=temp;
        }
        result[0]=arr[head.next.val];
        for(int i=k;i<n;i++){
             while(tail.prev.val!=-1 && arr[tail.prev.val]<=arr[i]){
                tail.prev.prev.next=tail;
                tail.prev=tail.prev.prev;
            }
            Node temp=new Node(i);
            temp.prev=tail.prev;
            temp.next=tail;
            temp.prev.next=temp;
            tail.prev=temp;

            while(head.next.val<i-k+1){
                head.next=head.next.next;
                head.next.prev=head;
            }
            result[i-k+1]=arr[head.next.val];
        }
        return result;
    }
}

class Node{
    int val;
    Node prev;
    Node next;
    Node(int val){
        this.val=val;
    }
}