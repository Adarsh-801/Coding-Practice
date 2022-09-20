QUESTION LINK - https://practice.geeksforgeeks.org/problems/multiply-two-linked-lists/1
EXPLANATION LINK - Analyze the formula used to make the linked list into a number.
  
======================================================================ANSWER===========================================================================================
  
class GfG{
  
   public long multiplyTwoLists(Node l1,Node l2){
        
        long mod = 1000000007;
        Node temp1 = l1;
        Node temp2 = l2;
        
        long num1 = 0;
        long num2 = 0;
        
        while(temp1 != null){
            num1 = ((num1*10)+(temp1.data))%mod;
            temp1 = temp1.next;
        }
        
        while(temp2 != null){
            num2 = ((num2*10)+(temp2.data))%mod;
            temp2 = temp2.next;
        }
        
        long ans = (num1*num2)%mod ;
        return ans;
   }
}
