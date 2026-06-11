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
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int len=count/k;

        count=0;
        ListNode prev=null;
        ListNode current=head;
        //ListNode next=null;
        ListNode first=null;
        ListNode prevLast=null;
        ListNode result=null;
        for(int i=0;i<len;i++){
            first=current;
            while(current!=null && count!=k){
                temp=current.next;
                current.next=prev;
                prev=current;
                current=temp;
                count++;
            }
            first.next=current;
            if(i==0){
                result=prev;
                prevLast=first;
            }else{
                prevLast.next=prev;
                prevLast=first;
            }
            prev=null;
            count=0;
        }
        prevLast.next=current;
        //first.next=current;

        return result;
    }
}