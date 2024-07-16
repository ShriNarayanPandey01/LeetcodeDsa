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
    if(k==1)
    return head;
    ListNode dummy = new ListNode(0);
    dummy.next=temp;
    ListNode new1=helper(head,1,k);
    return temp;
    }
    int n=0;
    ListNode temp=null;
    public ListNode helper(ListNode root,int i,int k){
        if(root.next==null){
            n=i%k;
            temp=root;
            return root;
        }
        ListNode ji=helper(root.next,i+1,k);
        if(n>0){
            n--;
            root.next=ji;
            temp=root;
            return root;
        }
        if(i%k==0){
            root.next=temp;
            temp=root;
            return root;
        }
        else{

            root.next=ji.next;
            ji.next=root;
            return root;
        }
    }
}
class solition1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)
        return head;
        ListNode dummy = new ListNode(0);
        dummy.next=temp;
        ListNode new1=helper(head,1,k);
        return temp;
    }
     int n=0;
     ListNode temp=null;
     public ListNode helper(ListNode root,int i,int k){
        if(root.next==null){
            n=i%k;
            temp=root;
            return root;
        }
        ListNode ji=helper(root.next,i+1,k);
        if(n>0){
            n--;
            root.next=ji;
            temp=root;
            return root;
        }
        if(i%k==0){
            root.next=temp;
            temp=root;
            return root;
        }
        else{

            root.next=ji.next;
            ji.next=root;
            return root;
        }
    }
}