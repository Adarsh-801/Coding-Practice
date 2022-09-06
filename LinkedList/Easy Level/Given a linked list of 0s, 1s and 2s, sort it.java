QUESTION LINK - https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        Node temp  = head;
        
        while(temp != null){
            
            if(temp.data == 0) count0++;
            else if(temp.data == 1) count1++;
            else count2++;
            
            temp = temp.next;
        }
        
        temp = head;
        
        while(temp != null){
            
            while(count0 > 0){
                temp.data = 0;
                count0--;
                temp = temp.next;
            }
            
            while(count1 > 0){
                temp.data = 1;
                count1--;
                temp = temp.next;
            }
            
            while(count2 > 0){
                temp.data = 2;
                count2--;
                temp = temp.next;
            }
        }
        
        return head;
    }
}
