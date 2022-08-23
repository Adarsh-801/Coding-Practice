QUESTION LINK - https://practice.geeksforgeeks.org/problems/number-of-coins1824/1
  
EXPLANATION LINK - https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16
  
===========================================================================ANSWER=====================================================================================
  
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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int m, int v) 
	{ 
	    
	    int dp[][] = new int[m+1][v+1];
	    
	    for(int i=0; i<dp.length; i++){
	        for(int j=0; j<dp[0].length; j++){
	            
	            //first column
	            if(j==0){
	                dp[i][j] = 0;
	            }
	            
	            //first row
	            if(i==0){
	                dp[i][j] = Integer.MAX_VALUE - 1;
	            }
	        }
	    }
	    
	    
	    //initializing the second row
	    for(int j=1; j<dp[0].length; j++){
	        if(j % coins[0] == 0){
	            dp[1][j] = j / coins[0];
	        }
	        else{
	            dp[1][j] = Integer.MAX_VALUE - 1;
	        }
	        
	    }
	    
	    
	    //filling the rest of the matrix
	    for(int i=2; i<dp.length; i++){
	        for(int j=1; j<dp[0].length; j++){
	            
	            if(coins[i-1] <= j){
	                dp[i][j] = Math.min( 1+dp[i][j-coins[i-1]] , dp[i-1][j]);
	            }
	            else{
	                dp[i][j] = dp[i-1][j];
	            }
	        }
	    }
	    
	    
	    if(dp[m][v] == Integer.MAX_VALUE-1){
	        return -1;
	    }
	    
	    
	    return dp[m][v];
	} 
}
