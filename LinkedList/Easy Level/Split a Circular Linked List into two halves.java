QUESTION LINK - https://practice.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1
EXPLANATION LINK - DRY RUN THE CODE ITS SELF EXPLANATORY
  
======================================================================ANSWER===========================================================================================
  
class gfg
{
    // Function  to split a circular LinkedList
    void splitList(circular_LinkedList list)
    {
        Node head1 = list.head;
        
        //finding middle element
        Node slow = head1;
        Node fast = head1;
        while(fast.next != head1 && fast.next.next != head1 ){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        //divide the LL
        Node tail1 = slow;
        Node head2 = tail1.next;
        tail1.next = null;
        
        Node tail2 = head2;
        while(tail2.next != head1){
            tail2 = tail2.next;
        }
        
        //make the curcular links
        tail1.next = head1;
        tail2.next = head2;
        
        list.head1 = head1;
        list.head2 = head2;
	}
}
