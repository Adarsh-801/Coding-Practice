QUESTION LINK - https://practice.geeksforgeeks.org/problems/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/1
EXPLANATION LINK - https://www.youtube.com/watch?v=UyX22tCpzhI
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    public static int maxSubStr(String str) {
        
        int n = str.length();
        
        int count_zero = 0;
        int count_one = 0;
        
        int final_count = 0;
        
        for(int i=0; i<n; i++){
            
            if(str.charAt(i) == '0')    count_zero++;
            else                        count_one++;
            
            if(count_zero == count_one){
                final_count++;
                count_zero = 0;
                count_one = 0;
            }
        }
        
        if(final_count == 0 || count_zero != count_one)    return -1;
        else                    return final_count;
    }
}
