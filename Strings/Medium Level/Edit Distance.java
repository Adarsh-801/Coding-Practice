QUESTION LINK - https://practice.geeksforgeeks.org/problems/edit-distance3702/1
APPROACH - 1. Recursion - 30/80 test cases pass
           2. Memoization - 80/80 test cases pass
           3. Tabulation - 80/80
EXPLANATION LINK - 
  
======================================================================ANSWER===========================================================================================

class Solution {
    public int editDistance(String s, String t) {
        
        int n1 = s.length();
        int n2 = t.length();
        
        return helper(n1-1, n2-1, s, t);
    }
    
    public int helper(int i, int j, String s, String t){
        
        //base case
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(s.charAt(i) == t.charAt(j)){
            return helper(i-1, j-1, s, t);
        }
        
        //delete, insert , replace respectively
        return 1 + Math.min( helper(i-1, j, s, t) , 
                             Math.min( helper(i, j-1, s, t) , helper(i-1, j-1, s, t)) );
    }
}


----------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
class Solution {
    public int editDistance(String s, String t) {
        
        int n1 = s.length();
        int n2 = t.length();
        int[][] dp = new int[n1][n2];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){   
                
                dp[i][j] = -1;
            }
        }
        
        return helper(n1-1, n2-1, s, t, dp);
    }
    
    public int helper(int i, int j, String s, String t, int[][] dp){
        
        //base case
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = 0 + helper(i-1, j-1, s, t, dp);
        }
        
        //delete, insert , replace respectively
        return dp[i][j] = 1 + Math.min( helper(i-1, j, s, t, dp) , 
                             Math.min( helper(i, j-1, s, t, dp) , helper(i-1, j-1, s, t, dp)) );
    }
}


--------------------------------------------------------------------------------------------------------------------------------------------------------------------
  

class Solution {
    public int editDistance(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[n+1][m+1];
        
        //filling the base cases first
        for(int i=0; i<=n; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=m; j++){
            dp[0][j] = j;
        }
        
        //now filling the rest of the matrix
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                
                //if the characters match
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 0 + dp[i-1][j-1];
                }
                
                else{
                    dp[i][j] = 1 + Math.min( dp[i][j-1] , Math.min( dp[i-1][j] , 
                                                                    dp[i-1][j-1]));
                }
            }
        }
        
        return dp[n][m];
    }
}

  

