QUESTION LINK - https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            pq.add(arr[i]);
        }
        
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = pq.remove();
        }
        
        return ans;
    }
}
