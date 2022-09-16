QUESTION LINK - https://practice.geeksforgeeks.org/problems/isomorphic-strings/0
EXPLANATION LINK - https://www.youtube.com/watch?v=6Qkail843d8
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        Map<Character , Character> map1 = new TreeMap<>();
        Map<Character , Boolean> map2 = new TreeMap<>();
        
        if(str1.length() != str2.length())   return false;
        
        for(int i=0; i<str1.length(); i++){
            
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            
            if(map1.containsKey(ch1)){
                
                if(map1.get(ch1)  != ch2)   
                    return false;
            }
            else{
                
                if(map2.containsKey(ch2) == true)   return false;
                
                else{
                    map1.put( ch1 , ch2 );
                    map2.put( ch2 , true );
                }
            }
        }
        
        return true;
    }
}
