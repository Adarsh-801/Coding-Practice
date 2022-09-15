QUESTION LINK - https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    //Function to find the height of a binary tree.
    int height(Node node) 
    {
        int height = 0;
        
        //base case
        if(node == null) return 0;
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        if(leftHeight > rightHeight){
            return leftHeight+1;
        }
        else{
            return rightHeight+1;
        }
    }
}
