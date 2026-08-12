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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyleft=new ListNode (0);
        ListNode dummyright=new ListNode(0);
        ListNode lefthead=dummyleft;
        ListNode righthead=dummyright;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                lefthead.next=temp;
                lefthead=lefthead.next;
            }
            else
            {
                righthead.next=temp;
                righthead=righthead.next;
            }
            temp=temp.next;
        }
        righthead.next=null;
        lefthead.next=dummyright.next;
        return dummyleft.next;
        
    }
}