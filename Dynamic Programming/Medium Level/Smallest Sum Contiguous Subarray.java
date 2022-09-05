QUESTION LINK - https://practice.geeksforgeeks.org/problems/smallest-sum-contiguous-subarray/1
EXPLANATION LINK - Reverse of Kadane's Algo
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    static int smallestSumSubarray(int a[], int size)
    {
        int csum = a[0];
        int osum = a[0];
        
        for(int i=1; i<size; i++){
            
            csum = Math.min(a[i] , csum+a[i]);
            osum = Math.min(csum , osum);
        }
        
        return osum;
    }
}
