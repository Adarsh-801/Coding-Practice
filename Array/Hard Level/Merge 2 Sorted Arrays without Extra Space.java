QUESTION LINK - https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
  
EXPLANATION LINK - https://www.youtube.com/watch?v=H7ADLLVrxis&t=699s

APPROACH - 1. Sorted array approach  (Time Limit Exceeded after 280 cases)
           2. Gap method (Optimal Solution)
====================================================================ANSWER=============================================================================================
  
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        
        int j = 0; //variable to iterate over arr2
        int i = 0; //variable to iterate over arr1
        
        while(i<n){
            
            if(arr1[i] > arr2[j]){
                //swap
                long temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                
                //now sort second array again
                Arrays.sort(arr2);
            }
            
            i++;
        }
    }
}



--------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
  
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        
        int i=0;
        int j =0 ;
        int gap=n+m;
        
        //now we will run a for loop until the gap exists 
        //for calculating gap after every iteration we use a separate fuction
        for(gap = nextgap(gap) ; gap>0; gap = nextgap(gap)){
            
            //this loop will work when both the pointers are within the first array
            for(i =0; i+gap <n; i++){
                if(arr1[i] > arr1[i+gap])
                {
                    long temp = arr1[i];
                    arr1[i] = arr1[i+gap];
                    arr1[i+gap] = temp;
                }
            }
            
            //this section would work if i and j are in two different arrays
            for(j = gap>n? gap-n:0; i<n && j<m ; i++,j++){
                
                if(arr1[i] > arr2[j]){
                    long temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
            
            //this loop will work when both i and j would be within second array
            if(j<m){
                for( j=0; j+gap <m; j++){
                    if(arr2[j] > arr2[j+gap])
                    {
                        long temp = arr2[j];
                        arr2[j] = arr2[j+gap];
                        arr2[j+gap] = temp;
                    }
                }
            }
        }
    }
    
    public static int nextgap(int gap){
        if(gap <=1)
           return 0;
           
        return (gap/2) + gap%2;  //formula for ceil value, in built ceil() function
                                            //can also be used
    }
}
