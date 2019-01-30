//Leetcode 61

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int count = 1;
        ListNode chead = head; //for counting
        ListNode tail = head;
        while(chead.next != null){ //O(n)
            chead = chead.next; //!!!!pointer or dot
            count++;
            tail = chead;
        }
        
        int newhead_pos = count+1 - (k%count);
        
        ListNode prenewhead = null;
        int newcount =1;
        tail.next = head;
        while(head.next != null){ //O(newhead_pos)
            if(newcount == newhead_pos){ //reach the gola
                prenewhead.next = null;
                return head;
            }
            prenewhead = head;
            head = head.next;
            newcount++;  //typo
        }
        return head;
        //Total runtime O(n+ newhead_pos)
    }
}

//Others

public ListNode rotateRight(ListNode head, int k) {

if (head == null || k == 0 || head.next == null){
return head;
}

ArrayList<ListNode> list = new ArrayList<ListNode>();
while (head != null){
list.add(head);
head = head.next;
}

if (k % list.size() == 0){
return list.get(0);
}

int start = list.size() - (k % list.size());
list.get(list.size() - 1).next = list.get(0);
list.get(start - 1).next = null;
return list.get(start);

}
