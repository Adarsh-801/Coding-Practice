QUESTION LINK - https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
EXPLANATION LINK - https://www.youtube.com/watch?v=DK5OKKbF6GI
APPROACH - 1. O(n^3). Make all the posiible substrings then check if the sunstring is a pallindrome or not, if pallindrome then find the longest one
           2. O(n). 
  
======================================================================ANSWER===========================================================================================
  
class Solution{
    static String longestPalin(String S){
        
        int maxLength = 1;
        String res = "" + S.charAt(0);
        
        for(int i=0; i<S.length()-1; i++){
            for(int j=i+1; j<S.length(); j++){
                
                //create a temp substring
                String temp = S.substring(i , j+1);
                
                //check if temp substring is a pallindrome
                if(isPallindrome(temp)){
                    
                    //check if the temp pallindrome length > maxLength
                    if(maxLength < temp.length()){
                        maxLength = temp.length();
                        res = temp;
                    }
                }
            }
        }
        
        return res;
    }
    
    public static boolean isPallindrome(String temp){
        
        int si = 0; //startIndex
        int ei = temp.length()-1; //endIndex
        
        while(si <= ei){
            if(temp.charAt(si) != temp.charAt(ei)){
                return false;
            }
            si++;
            ei--;
        }
        return true;
    }
}


-------------------------------------------------------------------O(n)--------------------------------------------------------------------------------------------
  
class Solution{
    static String longestPalin(String s){
        // code here
        
        String max="";
        
        for( int i=0 ; i<s.length(); i++){
            
            String onecenter  = findLongestCount( s , i , i); // one center ..bab
            String twocenter = findLongestCount( s, i , i+1 ); // may be two center...baab
            
            String bigger = (onecenter.length() > twocenter.length() ) ? 
                            onecenter : twocenter;
            
            if( bigger.length() > max.length() ){
                max = bigger;
            }
        }
        
        return max;
        
    }
    
    
     public static String findLongestCount( String s , int left , int right){
       
       int count=0;
       int max =0; 
       String longest = "";
       
       while( left>=0 && right<s.length() && (s.charAt(left)==s.charAt(right) ) ){
           
           if( left == right ){  // if center is having one element..and left,right point to that
               count += 1;
           }else{     
               count += 2;
           }
           
           if( count > max ){
               max  = count;
               longest = s.substring( left , right+1);
           }
           
           left = left-1;
           right = right+1;    
       } 
        return longest;
   }
}
