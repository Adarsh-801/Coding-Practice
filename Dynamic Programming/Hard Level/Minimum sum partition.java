QUESTION LINK - https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1

EXPLANATION - https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10

=======================================================================ANSWER==========================================================================================
  
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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    int sum = 0;
	    for(int i=0; i<arr.length; i++){
	        sum += arr[i];
	    }
	    
	    boolean dp[][] = new boolean[n+1][sum+1];
	    
	    for(int i=0; i<dp.length; i++){
	        for(int j=0; j<dp[0].length; j++){
	            
	            //first row
	            if(i==0)
	                dp[i][j] = false;
	            
	            //first column
	            if(j==0)
	                dp[i][j] = true;
	        }
	    }
	    
	    //filling the rest of the matrix
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
	    
	    ArrayList<Integer> list = new ArrayList<>();
	    
	    for(int j=0; j<=sum/2; j++){
	        if(dp[n][j] == true){
	            list.add(j);
	        }
	    }
	    
	    int mini = Integer.MAX_VALUE;
	    
	    for(int i=0; i<list.size(); i++){
	        mini = Math.min(mini , (sum-(2*list.get(i))));
	    }
	    
	    return mini;
	} 
}
