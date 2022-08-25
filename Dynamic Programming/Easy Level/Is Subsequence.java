QUESTION LINK - https://leetcode.com/problems/is-subsequence/submissions/
VIDEO LINK - https://www.youtube.com/watch?v=QVntmksK2es&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30

========================================================ANSWER=====================================================================================
class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int m = s.length();
        int n = t.length();
        int dp[][] = new int[m+1][n+1];
        
        
        for(int i =0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }
        
        for(int i =1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                
                if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1+ dp[i-1][j-1];
                
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        
        if(dp[m][n] == m) return true;
        else return false;
    }
}
