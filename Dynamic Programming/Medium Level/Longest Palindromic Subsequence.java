QUESTION LINK - https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1
  
EXPLANATION LINK - https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26

APPROACH - We solve this question using Longest Common Subsequence (LCS) method , but LCS requires 2 strings but we are given only one. So to generate the second              string we reverse the given string.

           First Sting - S
           Second string - rev_S     (reverse of S)
  
            Now we perform LCS as usual and get the Longest Pallindromic Subsequence.
  
=======================================================================ANSWER=======================================================================================
  
  
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        String s2 = reverse(S);
        
        int m = S.length();
        int n = s2.length();
        
        return lcs(S, s2, m, n);
    }
    
    public String reverse(String s){
        
        String rev_s = "";
        for(int i=s.length()-1; i>=0; i--){
            rev_s += s.charAt(i);
        }
        
        return rev_s;
    }
    
    public int lcs(String s1, String s2, int m, int n){
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n];
    }
}
