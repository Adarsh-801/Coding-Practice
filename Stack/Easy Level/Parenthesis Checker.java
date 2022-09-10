QUESTION LINK - https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<x.length(); i++){
            char ch = x.charAt(i);
            
            if(ch=='('  ||  ch =='['  ||  ch=='{' ){
                st.push(ch);
            }
            
            else{ 
                    if((ch == ')' && !st.isEmpty() && st.peek() == '(' ) || 
                        (ch == ']' && !st.isEmpty() && st.peek() == '[' ) || 
                        (ch == '}' && !st.isEmpty() && st.peek() == '{' ) )
                    {
                        st.pop();
                    }
                    
                    else{
                        return false;
                    }
            }
        }
        
        return st.isEmpty();  
    }
}
