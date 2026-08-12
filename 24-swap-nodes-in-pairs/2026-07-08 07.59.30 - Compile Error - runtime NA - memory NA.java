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
    public ListNode swapPairs(ListNode head) {
       
        if(head==null || head.next==null)
        return head;

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy;
       while(fast!=null && fast.next.next!=null){
         ListNode first=fast.next;
        ListNode second=first;
        
        first.next=second.next;
        second.next=first
        first.next=second;
        fast=first;
       }
        return dummy.next;
    }
}