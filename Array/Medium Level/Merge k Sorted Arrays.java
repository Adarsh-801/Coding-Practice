QUESTION LINK - https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                list.add(arr[i][j]);
            }
        }
        
         Collections.sort(list);
         return list;
    }
}
