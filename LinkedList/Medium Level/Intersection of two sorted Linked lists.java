QUESTION LINK - https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1
EXPLANATION LINK - https://www.youtube.com/watch?v=3cLRaWPiIxo

=========================================================================ANSWER========================================================================================
  
//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
class GfG
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Sol obj = new Sol();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Sol
{
   public static Node findIntersection(Node head1, Node head2)
    {
        
        Node temp1 = head1; 
        Node temp2 = head2;
        
        Node newHead = null;
        Node current = null;
        
        while(temp1!=null && temp2 != null){
            
            if(temp1.data == temp2.data){
                
                //if its the first node of intersecction LL
                if(newHead == null){
                    Node temp = new Node(temp1.data);
                    newHead = temp;
                    current = newHead;
                }
                //if not the first
                else{
                    Node temp = new Node(temp1.data);
                    current.next = temp;
                    current = current.next;
                }
                
                //now iterate over in both the LL
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            
            else if(temp1.data < temp2.data){
                temp1 = temp1.next;
            }
            
            else{
                temp2 = temp2.next;
            }
        }
        
        return newHead;
    }
}
