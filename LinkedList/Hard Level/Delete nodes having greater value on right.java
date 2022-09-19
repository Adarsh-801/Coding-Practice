QUESTION LINK - https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1
EXPLANATION - First reverse the LL because it will be easy to traverse that way.
              Now create a new LL with the which will store the ans
              Finally reverse the answer LL again to give the final answer in porper order.
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    Node compute(Node head)
    {
       if(head == null)     return null;
       
       Node revHead = reverse(head);
       
       Node ansHead = new Node(0);
       Node ansTail = ansHead;
       
       Node current = revHead;
       int max = current.data;
       
       while(current != null){
           if(current.data >= max){
               max = current.data;      //update max
               ansTail.next = new Node(max); //move the ansTail forward
               ansTail = ansTail.next;
           }
           
           current = current.next;
       }
       
       //now after the while loop we have a new LL from  ansHead -> ansTail
       //but the ansHead contains 0 because we created it 
       //so the actual answer exists from secind element of the new LL
       //so we reverse the  from next node of the ansHead
       return reverse(ansHead.next);
       
    }
    
    public Node reverse(Node head){
        Node current = head;
        Node prev = null;
        Node next = null;
        
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } 
        return prev;
    }
}
