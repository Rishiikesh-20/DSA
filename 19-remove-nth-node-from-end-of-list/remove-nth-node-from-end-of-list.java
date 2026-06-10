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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        ListNode current=head;
        int count=0;
        while(current!=null){
            count++;
            current=current.next;
        }
        int find=count-n+1;

        current=head;
        ListNode prev=null;
        while(find!=1){
            find--;
            prev=current;
            current=current.next;
        }

        if(current==temp){
            return current.next;
        }
        prev.next=current.next;
        return temp;
    }
}