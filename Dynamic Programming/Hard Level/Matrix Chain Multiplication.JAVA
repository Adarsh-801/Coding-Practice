QUESTION LINK - https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
EXPLANATION LINK - https://www.youtube.com/watch?v=kMK148J9qEE&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=33

STEPS TO FOLLOW - 
1.Find i and j
2. Find base conditions
3. Find k loop - It can be done using 2 schemes
		     Scheme1 - k=i; k<=j-1; k++       Function call for this scheme - solve(i to k) and solve(k+1 to j)
		     Scheme2 - k=i+1; k<=j; k++       Function call for this scheme - solve(i to k-1) and solve(k to j)
4.Calculate answer from the small answer



==========================================================================ANSWER======================================================================================

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int dp[][] = new int[101][101];
    
    static int matrixMultiplication(int N, int arr[]){
        
        //initializing the matrix with -1
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                
                dp[i][j] = -1;
            }
        }
        
        int i = 1;
        int j = N-1;
        
        return helper(arr, i , j);
    }
    
    public static int helper(int[] arr, int i, int j){
        
        if(i>=j)
            return 0;
            
        int min = Integer.MAX_VALUE;
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        for(int k=i; k<j; k++){
            int smallAns = helper(arr, i, k) + helper(arr, k+1, j) + 
                           (arr[i-1]*arr[k]*arr[j]);
                           
            if(smallAns < min){
                min = smallAns;
            }
            
        }
        
        return dp[i][j] = min;
    }
}
