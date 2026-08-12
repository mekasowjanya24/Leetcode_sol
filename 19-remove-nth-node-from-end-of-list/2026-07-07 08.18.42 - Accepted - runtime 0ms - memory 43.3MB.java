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
        ListNode dummy =new ListNode(-1);
        dummy.next=head;
        ListNode temp=head;
        ListNode prev=dummy;
        
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        int k=count-n;
        for(int i=0;i<k;i++){
            prev=prev.next;
        }
        prev.next=prev.next.next;
        return dummy.next;
        
    }
}