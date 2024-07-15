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
ListNode dummy=new ListNode(1);
hlp(l1,l2,dummy);
return dummy.next;
}
int carry=0;
public void hlp(ListNode l1, ListNode l2,ListNode temp){
    if(l1==null && l2==null && carry==0)
    return;
    int p = (l1!= null) ? l1.val : 0;
    int q = (l2!= null) ? l2.val : 0;
    int sum=p+q+carry;
    carry=sum/10;
    temp.next=new ListNode(sum%10);
    if(l1!=null)l1=l1.next;
    if(l2!=null)l2=l2.next;
    hlp(l1,l2,temp.next);
}

}