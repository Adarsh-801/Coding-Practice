QUESTION LINK - https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1?page=1&category[]=sliding-window&sortBy=submissions
  
APPROACH - 1.HashSet Appraoch
           2.Sliding window technique for variable size window
  
==========================================================================ANSWER=======================================================================================
  
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
			//code
			
		//taking input using class Scanner
		Scanner scan = new Scanner(System.in);
		
		//taking total number of testcases
		int t = scan.nextInt();
		while(t>0)
		{
		    //taking total count of elements
		    int n = scan.nextInt() ;
		    
		    //Declaring and Initializing an array of size n
		    int arr[] = new int[n];
		    
		    //adding elements to the array
		    for(int i = 0; i<n;i++)
		    {
		        arr[i] = scan.nextInt();
		    }
		    
		    t--;
		    
		     //calling the method findSum
		     //and print "YES" or "NO" based on the result
		     System.out.println(new Solution().findsum(arr,n)==true?"Yes":"No");
		}
	}
	
	
}
// } Driver Code Ends


class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        Set<Integer> s = new HashSet<>(n);
        
        int sum = 0;
        
        //we add 0 into the set
        s.add(sum);
        
        for(int i=0; i<n; i++){
            
            sum += arr[i];
            
            /* the hashset already has a 0 in in it, so after a few elements 
            to the sum we check if the sum = 0. Now if set contains o already 
            that means there is a subarray possible with 0 sum hence we return 
            true.   */
            if(s.contains(sum))  return true;
            
            else s.add(sum);
            
        }
        
        return false;
    }
}
