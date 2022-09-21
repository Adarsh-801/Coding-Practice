QUESTION LINK - https://practice.geeksforgeeks.org/problems/license-key-formatting/1
  
======================================================================ANSWER===========================================================================================
  
class Solution{
    static String ReFormatString(String S, int K){
        
        S = S.toUpperCase(); //make all uppercase
        S = S.replaceAll( "-" , "");    //now remove all '-'
        
        StringBuilder sb = new StringBuilder(S); //create an empty srting builder
        
        //now make groups of k form the end of the queue 
        //after u traverse k characters insert a '-'
        for(int i=S.length()-K; i>0; i=i-K){
            sb.insert(i , "-");
        }
        
        //now convert string builder to string and return it
        return sb.toString();
    }
}
