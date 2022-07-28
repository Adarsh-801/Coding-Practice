QUESTION LINK - https://leetcode.com/problems/reverse-linked-list/

NOTE - Copy paste the link it is not clickable


=======================================================================================================================================================================
=============================================================ANSWERS==================================================================================================
  
 --------------------------------------------------------------RECURSIVE APPROACH-------------------------------------------------------------------------------
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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        //Sacving the address of the the second node in a variable coz it will
        //be the last node of the recirsive answer
        ListNode temp = head.next;
        
        //Saving the head of the smallAns in a variable
        ListNode newHead  = reverseList(head.next);
        
        temp.next = head;
        
        head.next = null;
        
        return newHead;
        
    }
}

-----------------------------------------------------------ITERATIVE APPROACH----------------------------------------------------------------------------------
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
    public ListNode reverseList(ListNode head) {
        
        ListNode currentNode = head;
        ListNode previousNode = null;
        ListNode temp;
        
        while(currentNode != null){
            temp = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = temp;  
        }
        
        return previousNode;
    }
}
