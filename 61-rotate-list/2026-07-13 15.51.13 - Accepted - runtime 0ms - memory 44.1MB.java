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
        if(head==null || head.next==null)
        return head;
        ListNode temp=head;
        int count=1;
        while(temp.next!=null){
            count++;
            temp=temp.next;
        }
        temp.next=head;
        k= k % count;
        if(k==0){
            temp.next=null;
            return head;
        }
        ListNode prev=head;
        int c=0;
        while(c<count-k-1){
            prev=prev.next;
            c++;
        }
        ListNode newhead=prev.next;
        prev.next=null;
        return newhead;

        
    }
}