QUESTION LINK - https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1?page=1&category[]=sliding-window&sortBy=submissions

EXPLANATION LINK - Use silding window technique for varaible size window 

==============================================================================ANSWER=================================================================================

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        int val =0;
        int k=0;
        
        // Your code here
        for(int i=0;i<n;i++){
            
           val=0;
           
            for(int j=k;j<n;j++){
               val += arr[j];
               
               if(val >s){
                   break;
               }
               
               if(val == s){
                   list.add(k+1);
                   list.add(j+1);
                   return list;
               }

           }
           
           k++;
        }
        
        list.add(-1);
        return list;
    }
}
