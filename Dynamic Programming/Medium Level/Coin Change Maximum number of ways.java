QUESTION LINK - https://practice.geeksforgeeks.org/problems/coin-change2448/1
  
EXPLANATION LINK - https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=15
  
  
=========================================================================ANSWER=======================================================================================

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for (int i = 0; i < m; i++) Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(Arr, m, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int S[], int m, int n) {
        
        long dp[][] = new long[m+1][n+1];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                
                //first row
                if(i==0)
                    dp[i][j] = 0;

                //first column                    
                if(j==0)
                    dp[i][j] = 1;
            }
        }
        
        
        //filling the rest of the matrix
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                
                if(S[i-1] <= j){
                    dp[i][j] = dp[i][j -S[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}
