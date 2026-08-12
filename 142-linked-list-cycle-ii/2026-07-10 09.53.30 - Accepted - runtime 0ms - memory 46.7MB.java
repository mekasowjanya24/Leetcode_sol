/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return funpos(head,slow);
            }
        }
        
    return null;      
}
private  ListNode funpos(ListNode head,ListNode slow){
    ListNode p1=head;
    ListNode p2=slow;
   
    while(p1!=p2){
        p1=p1.next;
        p2=p2.next;
    }

    return p1;
}
}