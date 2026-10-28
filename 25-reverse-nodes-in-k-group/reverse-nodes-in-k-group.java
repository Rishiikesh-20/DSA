/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode prevTail=null;
        ListNode cur=head;
        ListNode prev=null;
        ListNode resultHead=head;
        
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            if(count==k){
                resultHead=temp;
            }
            temp=temp.next;
        }
        if(count<k) return resultHead;

        int n=count/k;
        System.out.println(n);


        for(int i=0;i<n;i++){
            ListNode curTail=null;
            for(int j=0;j<k;j++){
                if(j==0) curTail=cur;
                temp=cur.next;
                cur.next=prev;
                prev=cur;
                cur=temp;
            }
            if(prevTail!=null) prevTail.next=prev;
            curTail.next=cur;
            prevTail=curTail;
            prev=null;
        }

        return resultHead;
    }
}