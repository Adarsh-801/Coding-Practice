QUESTION LINK - https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
APPROACH - 1. Time limit exceeded at 201/281 test cases
           2. Priority Queue appraoch - optimized
======================================================================ANSWER===========================================================================================
  
class Solution
{
    
    long minCost(long arr[], int n) 
    {
        
        long sum = 0;
        for(int i=0; i<n-1; i++){
            Arrays.sort(arr);
            sum =  sum + arr[i] + arr[i+1];
            arr[i+1] = arr[i] + arr[i+1];
        }
        
        return sum;
    }
}


---------------------------------------------------------------------------APPROACH 2--------------------------------------------------------------------------------
  
class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        //adding all elements to the PQ
        for(long i : arr){
            pq.add(i);
        }
        
        long ans = 0; //to store ans
        
        while(pq.size() >= 2){
                long current = pq.poll() + pq.poll(); //add the 2 minimum numbers and remove it from PQ
                
                ans+= current;
                
                pq.add(current); //add current back to PQ
        }
        
        return ans;
    }
}
  
