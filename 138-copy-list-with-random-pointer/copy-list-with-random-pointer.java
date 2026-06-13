/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node cur=head;

        while(cur!=null){
            Node temp=new Node(cur.val);
            Node next=cur.next;
            cur.next=temp;
            temp.next=next;
            cur=next;
        }

        cur=head;
        while(cur!=null){
            Node curRandom=cur.random;
            Node dupRandom=null;
            if(curRandom!=null){
                dupRandom=curRandom.next;
            }
            cur.next.random=dupRandom;
            cur=cur.next.next;
        }

        cur=head;
        Node result=head.next;
        while(cur!=null){
            Node dup=cur.next;
            cur.next=dup.next;
            if(cur.next==null){
                dup.next=null;
            }else
                dup.next=cur.next.next;
            cur=cur.next;
        }
        return result;
    }
}