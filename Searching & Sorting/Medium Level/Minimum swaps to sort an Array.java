QUESTION LINK - https://practice.geeksforgeeks.org/problems/minimum-swaps/1
EXPLANATION LINK - dry run
  
======================================================================ANSWER===========================================================================================

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        HashMap<Integer , Integer> map = new HashMap<>();
        int swapCount = 0;
        
        int visited[] = new int[nums.length];
        
        //fill the sorted array same as the nums array
        for(int i=0; i<nums.length; i++){
            visited[i] = nums[i];
        }
        
        //Sort the "sorted" array
        Arrays.sort(visited);
        
        //fill the hashmap
        for(int i=0; i<nums.length; i++){
            map.put(nums[i] , i);
        }
        
        //check for swaps
        for(int i=0 ; i<nums.length; i++){
            if(nums[i] !=  visited[i]){
                swapCount = swapCount + 1;
                
                int temp = map.get(visited[i]);
                int value = nums[i];
                
                //now swap
                int t = nums[i];
                nums[i] = nums[temp];
                nums[temp] = t;
                
                //update the hasmap with swapped values
                map.put(nums[i] , i);
                map.put(value, temp);
                
            }
        }
        
        return swapCount;
    }
}
