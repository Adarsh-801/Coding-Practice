QUESTION LINK -  https://leetcode.com/problems/decode-string/


======================================================================================================================================================================
======================================================================ANSWER==========================================================================================

class Solution {
    public String decodeString(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(char ch: s.toCharArray()){
            
            
            //if the character is anything other than a closing bracket push it
            if(ch != ']'){
                st.push(ch);
            }
            
            
            //now if the character is a closing bracket we do the following
            else{
                
                //first we get the string encapsulated by the brackets and
                //put it into the string builder.
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && Character.isLetter(st.peek())){
                    sb.insert(0, st.pop());
                }
                
                //we save the contents of the stringbuilde into a string
                String sub = sb.toString();
                
                //now we remove the opening bracket
                st.pop();
                
                
                //next we get the number of times we need to repeat the encapsulated string
                sb = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    sb.insert(0, st.pop());
                }
                
                //now the number captured is a string character we need to convert it to a integer
                int count = Integer.valueOf(sb.toString());
                
                
                //now we repeat the 'sub' string 'count' number of times and push it to the stack
                while(count>0){
                    for(char i: sub.toCharArray()){
                        st.push(i);
                    }
                    count--;
                }
            }
        }
        
        //now we take out the characters from the stack and put it into a string
        //to return the answer
        
        StringBuilder answer = new StringBuilder();
        while(!st.isEmpty()){
            answer.insert(0, st.pop());
        }
        
        return answer.toString();
    }
}
