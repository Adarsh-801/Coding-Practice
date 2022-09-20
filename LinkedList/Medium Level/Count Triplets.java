QUESTION LINK - https://practice.geeksforgeeks.org/problems/87f12e5c728d69a5322634776b54c75897d14daa/1
Approach - 1. We take one element and subract it from the required triplet sum , then we find if there are any pairs in linked list with such that all 3 will form                 triplet sum
           2. Use HashMap to store all the elements in it. Then take two nodes in and using two loops find the sum of the the two nodes, if the hashmap contains an               element such that it will sum all these 3 elements will form the required sum then it will we increase the count of triplets
  
======================================================================ANSWER========================================================================================
  
  
class Solve
{
    static int countTriplets(Node head, int x) 
    { 
        if(head == null)    return 0;
        
        //creating thee pointers
        Node current = head, first = null, last = null;
        int count = 0; //for storing the answer
        
        //loop that will send last pointer at the end of the LL
        while(last != null){
            last = last.next;
        }
        
        while(current != null){
            
            first = current.next;
            
            //count all the pairs in the range between first and last pointer
            //so that eventually u find all the 3 triplets
            count += countPair(first , last , x-current.data);
            
            current = current.next;
        }
        
        return count;
    } 
    
    
    public static int countPair(Node first, Node last, int value){
        
        int count = 0;
        
        /*The loop will keep on running till
        1.either first and last pointer go to null
        2. untill first and last pointer cross each other
        3.until the first and the last pointer point at the same node   */
        while(first != null && last!= null && last.next != first && first != last){
            
            if(first.data + last.data == value){
                count ++;
                first = first.next;
                last = last.prev;
            }
            
            else if(first.data + last.data < value){
                first = first.next;
            }
            
            else{
                last = last.prev;
            }
        }
     
        return count;   
    }
}



-------------------------------------------------------------------HASHMAP APPROACH---------------------------------------------------------------------------------
  
class Solve
{
    static int countTriplets(Node head, int x) 
    { 
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        //now adding all the nodes of the LL to the HashMap
        Node temp = head;
        while(temp != null){
            hm.put(temp.data , 1);  //put the data in hashmap
            temp = temp.next;       //increment temp
        }
        
        Node prev = head;
        int count = 0;          //to store the ans
        
        while(prev != null){
            Node current = prev.next;
            
            while(current != null){
                
                int remainder = x - (prev.data + current.data);
                
                if(hm.containsKey(remainder) && (remainder < prev.data) && (remainder < current.data)){
                    count++;
                }
                
                current = current.next;
            }
            prev = prev.next;
        }
        
        return count;
    } 
}
