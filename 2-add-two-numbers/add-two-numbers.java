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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode head=null;
        ListNode current=null;
        while(l1!=null && l2!=null){
            int sum=l1.val+l2.val+carry;
            int rem=sum%10;
            if(sum/10==1){
                carry=1;
            }else{
                carry=0;
            }

            if(head==null){
                head=new ListNode(rem);
                current=head;
            }else{
                ListNode temp=new ListNode(rem);
                current.next=temp;
                current=temp;
            }
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null){
            int sum=l1.val+carry;
            int rem=sum%10;
            if(sum/10==1){
                carry=1;
            }else{
                carry=0;
            }

            if(head==null){
                head=new ListNode(rem);
                current=head;
            }else{
                ListNode temp=new ListNode(rem);
                current.next=temp;
                current=temp;
            }
            l1=l1.next;
        }

        while(l2!=null){
            int sum=l2.val+carry;
            int rem=sum%10;
            if(sum/10==1){
                carry=1;
            }else{
                carry=0;
            }

            if(head==null){
                head=new ListNode(rem);
                current=head;
            }else{
                ListNode temp=new ListNode(rem);
                current.next=temp;
                current=temp;
            }
            l2=l2.next;
        }
        if(carry==1){
            ListNode temp=new ListNode(1);
            current.next=temp;
            current=temp;
        }

        return head;
    }
}