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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
      while(fast.next!=null && fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
      }
      ListNode secondhalf=reverse(slow.next);
       ListNode first=head;
      ListNode second=secondhalf;
      boolean result=true;
      while(second!=null){
        if(first.val!=second.val)
        {
            
            result=false;
            break;
        }
        first=first.next;
        second=second.next;
      }
        slow.next=reverse(secondhalf);
        return result;
    
}
      private ListNode reverse(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;

        }
        return prev;
      }
      }
     
