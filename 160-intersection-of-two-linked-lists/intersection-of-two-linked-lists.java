/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA;
        ListNode temp2=headB;
        int len1=0;
        while(temp1!=null){
            len1++;
            temp1=temp1.next;
        }

        int len2=0;
        while(temp2!=null){
            len2++;
            temp2=temp2.next;
        }

        int min=Math.min(len1,len2);

        temp1=headA;
        temp2=headB;
        int i=0;
        while((len1-min-i)!=0){
            i++;
            temp1=temp1.next;
        }

        i=0;
        while((len2-min-i)!=0){
            i++;
            temp2=temp2.next;
        }

        while(temp1!=temp2){
            temp1=temp1.next;
            temp2=temp2.next;
        }

        return temp1;
        

    }
}