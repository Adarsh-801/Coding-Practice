QUESTION LINK - https://practice.geeksforgeeks.org/problems/reverse-a-string-using-stack/1 
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    
    public String reverse(String S){
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<S.length(); i++){
            st.push(S.charAt(i));
        }
        
        String ans = "";
        while(!st.isEmpty())    ans += st.pop();
        
        return ans;
        

    }

}
