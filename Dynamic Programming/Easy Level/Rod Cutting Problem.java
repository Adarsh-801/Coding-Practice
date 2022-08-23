QUESTION LINK - https://practice.geeksforgeeks.org/problems/rod-cutting0840/1

EXPLANATION LINK - https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14

=================================================================================ANSWER==============================================================================

//{ Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        
        //making an array that stores the various lengths that can be cut 
        //from the rod
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }
        
        int length_of_array = arr.length;
        
        int dp[][] = new int[length_of_array+1][n+1];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                
                //initializing first row and first column
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        
        //filling the rest of the matrix
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                
               if(arr[i-1] <= j){
                   dp[i][j] = Math.max(price[i-1] + dp[i][j-arr[i-1]] , dp[i-1][j]);
               }
               else{
                   dp[i][j] = dp[i-1][j];
               }
            }
        }
        
        return dp[length_of_array][n];
    }
}
