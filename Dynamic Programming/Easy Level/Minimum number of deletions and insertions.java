QUESTIONS - https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
  
EXPLANTIONS - https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25
  
===================================================================ANSWERS============================================================================================

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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    
	    int m = str1.length();
	    int n = str2.length();
	    
	    int lcs_length = lcs(str1 , str2, m, n);
	    
	    int deletions = m-lcs_length;
	    int insertions = n-lcs_length;
	    
	    return (insertions + deletions);
	} 
	
	public int lcs(String s1 , String s2 , int m , int n){
	    
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
	                
	                dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
	            }
	        }
	    }
	    
	    return dp[m][n];
	}
}
