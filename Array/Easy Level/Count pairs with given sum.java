Question Link - https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1

APPROACH - Hashmap

======================================================================ANSWER===========================================================================================
  
//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        int count = 0;
        
        
        for(int i=0; i<n; i++){
            
            //counting the pairs
            if(hm.containsKey(k - arr[i])){
                count += hm.get(k - arr[i]);
            }
            
            //filling the hashmap
            if(hm.containsKey(arr[i])){
                hm.put( arr[i] , hm.get(arr[i])+1 );
            }
            
            else{
                hm.put( arr[i] , 1);
            }
            
            //hashmap can also be filled in one line using this code below
            // hm.put( arr[i] , hm.getOrDefault( arr[i] , 0) + 1);
        }
        
        return count;
    }
}
