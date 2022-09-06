QUESTION LINK - https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    int median(int matrix[][], int r, int c) {
        
        int[] arr = new int[r*c];
        int k=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                arr[k] = matrix[i][j];
                k++;
            }
        }
        
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
}
