QUESTION LINK - https://leetcode.com/problems/longest-common-subsequence/
  
EXPLANATION LINK - https://www.youtube.com/watch?v=4dMlCZTONj8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=18
  
===================================================================ANSWER===========================================================================================
  
-------------------------------------------------------------MEMOIZATION APPRAOCH-----------------------------------------------------------------------------------
  
class Solution {
    
    //making a global matrix for memoization
    int dp[][] = new int[1001][1001];   //size was decided by looking at the constraints
    
    
    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();

        //initializing all the cells of the global matrix with -1
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        
        return helper(text1, text2 , m ,n);
    }
    
    public int helper(String text1, String text2, int m, int n){
        
        //base case
        if(m==0 || n==0){
            return 0;
        }
        
        //if the answer exists int the matrix return it directly
        //else store it while making recursive calls
        
        if(dp[m][n] != -1)
            return dp[m][n];
        
        
        
        //choice diagram and return 
        if(text1.charAt(m-1) == text2.charAt(n-1)){
            return dp[m][n] = 1 + helper(text1 , text2 , m-1, n-1);
        }
        else{
            return dp[m][n] = Math.max( helper(text1, text2, m-1, n) , helper(text1, text2, m, n-1) );
        }
    }
}


----------------------------------------------------------------TABULATION APPROACH--------------------------------------------------------------------------------

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();
        
        int dp[][] = new int[m+1][n+1];
        
        //initialie first row and column
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1] );
                }
            }
        }
        
        return dp[m][n];
    }
}
