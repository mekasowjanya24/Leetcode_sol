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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode grpprevtail=dummy;
        while(true){
            ListNode kthnode=grpprevtail;
            for(int i=0;i<k && kthnode!=null;i++){
                kthnode=kthnode.next;
            }
            if(kthnode==null)
            break;
            ListNode grpstart=grpprevtail.next;
            ListNode nextgrpstart=kthnode.next;
            ListNode prev=nextgrpstart;
            ListNode curr=grpstart;
            while(curr!=nextgrpstart){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            grpprevtail.next=prev;
            grpprevtail=grpstart;
        }
        return dummy.next;

        
    }
}