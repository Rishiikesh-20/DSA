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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        if(k==0){
            return head;
        }
        int n=0;
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            n++;
            prev=temp;
            temp=temp.next;
        }
        if(k%n==0){
            return head;
        }
        n=n-k%n;
        temp=head;
        ListNode prev1=null;
        while(n>0){
            n--;
            prev1=temp;
            temp=temp.next;
        }
        prev1.next=null;
        prev.next=head;
        return temp;
    }
}