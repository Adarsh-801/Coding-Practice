QUESTION LINK - https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        
        int n = sizeOfStack;
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n/2; i++){
            st.push(s.pop());
        }
        s.pop();
        
        while(!st.isEmpty()){
            s.push(st.pop());
        }
    } 
}
