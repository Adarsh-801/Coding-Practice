QUESTION LINK - https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1
  
EXPLANAITON LINK - https://www.youtube.com/watch?v=CFwCCNbRuLY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=27
  
=============================================================================ANSWER==================================================================================
  
//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    
    //FORMULA - minDeletions = Length(str) - Longest Pallindromic Subsequence
    
    int minDeletions(String str, int n){
            
        int minDel = n - LPS(str, n);
        return minDel;
                
    }
    
    int LPS (String s1, int m){
        
        String s2 = reverse(s1);
        int n = s2.length();
        
        return LCS(s1, s2, m , n);
    }
    
    String reverse(String s1){
        
        String rev_s1 = "";
        for(int i=s1.length()-1; i>=0; i--){
            rev_s1 += s1.charAt(i);
        }
        
        return rev_s1;
    }
    
    int LCS(String s1, String s2, int m, int n){
       
       int dp[][] = new int[m+1][n+1] ;
       
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
