QUESTION LINK - https://classroom.codingninjas.com/app/classroom/me/10278/content/172387/offering/2139193/problem/331

================================================================ANSWER================================================================================================

/*

    Following is the Node class already written for the Linked List

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }

*/


public class Solution {

	public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
        
        if(head == null){
            return null;
        }
		
        LinkedListNode<Integer> oddH = null, evenH = null, oddT = null , evenT = null;
        LinkedListNode<Integer> temp = head;
        
        while(temp != null){
            
            if(temp.data % 2 == 0){
                
                if(evenH == null){
                    evenH = temp;
                    evenT = temp;
                }
                else{
                    evenT.next = temp;
                    evenT = temp;
                }
                
            }
            
            else{
                
                if(oddH == null){
                    oddH = temp;
                    oddT = temp;
                }
                else{
                    oddT.next = temp;
                    oddT = temp;
                }
            }
            temp = temp.next;
        }
        
        
        //base case
        if(oddH == null){
            return evenH;
        }
        
        if(evenH == null){
            return oddH;
        }
        oddT.next = evenH;
        evenT.next = null;
        
        
        
        return oddH;
	}
}
