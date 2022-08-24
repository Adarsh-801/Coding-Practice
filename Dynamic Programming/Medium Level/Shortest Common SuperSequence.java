QUESTION LINK - https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
  
EXPLANATION LINK - https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24
  
======================================================================ANSWER===========================================================================================
  
//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    
    /*FORMULA - LENGTH( shortest common subsequence) = LENGTH(String1) + LENGTH(String2)
                                                       - LENGTH(Longest Common Subsequence)
    */
    
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
      
        int lcs_length = lcs(X,Y,m,n);
        
        int answer = m+n-lcs_length;
        
        return answer;
        
    }
    
    public static int lcs(String x, String y, int m, int n){
        
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
                
                if(x.charAt(i-1) == y.charAt(j-1)){
                    
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
