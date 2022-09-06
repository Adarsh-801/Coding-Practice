QUESTION LINK - https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1
EXPLANATION - Dry Run
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        
        int i=0;
        int j = arr[0].length - 1;
        
        int firstRow = -1;
        
        while( i<arr.length && j>=0){
            if(arr[i][j] == 1){
                j--;
                firstRow = i;
            }
            else{
                i++;
            }
        }
        
        return firstRow;
    }
}
