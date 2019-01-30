//Leetcode 2

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int carry =0; //need add up 1 if reach 10 from previous
        ListNode dummy= new ListNode(0); //!!!!!
        ListNode it = dummy;
        
        while (l1 != null || l2 != null || carry !=0) {
            int val = carry + (l1 !=null ? l1.val:0);
            val += (l2 != null ? l2.val: 0);
            it.next = new ListNode(val%10);
            carry = val/10;
            it = it.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return dummy.next;
    }
}
