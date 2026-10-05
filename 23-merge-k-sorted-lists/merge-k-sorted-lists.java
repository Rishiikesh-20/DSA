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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode temp=lists[0];
        for(int i=1;i<lists.length;i++){
            temp=merge(temp,lists[i]);
        }
        return temp;
    }

    public ListNode merge(ListNode node1,ListNode node2){
        ListNode head=new ListNode(-1);
        ListNode cur=null;
        if(node1==null) return node2;
        if(node2==null) return node1;
        if(node1.val<=node2.val){
            cur=new ListNode(node1.val);
            node1=node1.next;
        }else{
            cur=new ListNode(node2.val);
            node2=node2.next;
        }
        head.next=cur;
        while(node1!=null && node2!=null){
            ListNode temp=cur;
            if(node1.val<=node2.val){
                cur=new ListNode(node1.val);
                node1=node1.next;
            }else{
                cur=new ListNode(node2.val);
                node2=node2.next;
            }
            temp.next=cur;
        }

        if(node1!=null){
            cur.next=node1;
        }
        if(node2!=null){
            cur.next=node2;
        }

        return head.next;
    }
}