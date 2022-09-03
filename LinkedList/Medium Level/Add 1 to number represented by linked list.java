QUESTION - https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1

=====================================================================ANSWER===========================================================================================
  
//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        Node revHead = reverse(head);
        Node temp = revHead;
        
        if(revHead.data < 9){
            revHead.data += 1;
        }
        
        else{
            while(temp != null){
                
                if(temp.data < 9){
                    temp.data += 1;
                    break;
                }
                
                if(temp.data == 9){
                    temp.data = 0;
                }
                temp = temp.next;
            }
            
        }
        
        Node ansHead = reverse(revHead);
        
        if(ansHead.data == 0){
            Node extra = new Node(1);
            extra.next = ansHead;
            
            return extra;
        }
        else{
            return ansHead;   
        }
    }
    
    public static Node reverse(Node head){
        Node prev= null;
        Node current = head;
        Node next = null;
        
        while(current!= null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
}
