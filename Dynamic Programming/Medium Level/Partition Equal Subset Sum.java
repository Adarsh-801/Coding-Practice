QUESTION LINK - https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1

EXPLANATION LINK - https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8

========================================================================ANSWER========================================================================================
  
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        
        int k = sum/2;
        
        //if the sum is odd then equal partitons can never be made
        if(sum%2 != 0){
            return 0;
        }
      
        //in case if the sum is even then we can find if there exists a subset with k in the array
        //if it exists then the other part would automatically be 'k' only....  so k+k= sum
        else{
            return subsetSum(N, arr , k);
        }
    }
    
  
    static int subsetSum(int N, int arr[], int k){
        
        boolean dp[][] = new boolean[N+1][k+1];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                
                if(i==0)
                    dp[i][j] = false;
                    
                if(j==0)
                    dp[i][j] = true;
            }
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        if(dp[N][k] == true){
            return 1;
        }
        else{
            return 0;
        }
    }
}
