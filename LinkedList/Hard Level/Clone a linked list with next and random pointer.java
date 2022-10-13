QUESTION LINK - https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1?page=1&difficulty[]=2&sortBy=difficulty
EXPLANATION LINK - https://www.youtube.com/watch?v=4apaOcK586U
  
======================================================================ANSWER===========================================================================================
  
  
class Clone {
    //Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        
        //Inserting new nodes in between the origional LL nodes
        Node curr = head;
        while(curr != null){
            Node temp = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = temp;
            curr = temp;
        }
        
        //set the curr node as head again
        curr = head;
        
        //copying the random pointers to the new node
        while(curr!= null){
            
            if(curr.next != null){
                
                if(curr.arb != null){
                    curr.next.arb = curr.arb.next;
                }
                else{
                    curr.next.arb = null;
                }
            }
            
            curr = curr.next.next;
        }
        
        //making pointers for the two duplicates LL
        Node realHead = head;
        Node dupHead = head.next;
        Node temp = dupHead; //for stroing the head of the duplicate LL
        
        //separating both origional and duplicate LL
        while(realHead != null &&  dupHead != null ){
            
            realHead.next = (realHead.next!=null) ? realHead.next.next : realHead.next;
            dupHead.next = (dupHead.next!=null) ? dupHead.next.next : dupHead.next;

            realHead = realHead.next;
            dupHead = dupHead.next;
        }
        
        return temp;
    }
}
