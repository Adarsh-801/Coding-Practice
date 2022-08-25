QUESTION - https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1

EXPLANATION - https://youtu.be/hbTaCmQGqLg?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
  
==============================================================================ANSWER=================================================================================
  
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int m = str.length();
        
        String s2 = str;
        
        int dp[][] = new int[m+1][m+1];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                
                if(str.charAt(i-1) == s2.charAt(j-1)  &&  i != j){
                    dp[i][j] = 1+ dp[i-1][j-1];
                    
                }
                
                else{
                    dp[i][j] = Math.max(dp[i-1][j] ,  dp[i][j-1]);
                }
            }
        }
        
        return dp[m][m];
    }
}
