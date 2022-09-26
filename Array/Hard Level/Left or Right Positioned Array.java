QUESTION LINK - https://practice.geeksforgeeks.org/problems/left-or-right-positioned-array5757/1
EXPLANATION LINK - DRY RUN
                   A number is in this correct position only it can be placed at one of the following two indices - 
                   1. when arr[i] = i -> under this condition the element is placed at the correct position from the left
                   2. when n-arr[i]-1 -> under this condition the element is placed at the correct position from the right
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    
    public static boolean leftRight(int arr[],int n)
    {
        //an array to keep record of visited elements
        int[] visited = new int[n];
        
        //traversing through each element of orogional array
        for(int i=0; i<n; i++){
            
            if(arr[i] < n){
                
                //this will hold true of left checking 
                if(visited[arr[i]] == 0){
                    visited[arr[i]] = 1;
                }
                //this will hold true for right checking
                else{
                    visited[n-arr[i]-1] = 1;
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                return false;    
            }
        }
        
        return true;
        
    }
}
