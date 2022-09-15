QUESTION LINK - https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
EXPLANATION LINK - https://www.youtube.com/watch?v=S0Bwgtn32uI&t=18s
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    // Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        
        //base case
        if(root == null) return 0;
        
        //if both ends of the diameter is on left side
        int leftDia = diameter(root.left);
        
        //if both ends of the diameter is on right side
        int rightDia = diameter(root.right);
        
        //if diameter goes through the root
        int f = height(root.left) + height(root.right)+1;
        
        return Math.max(leftDia , Math.max(rightDia , f));
    }
    
    int height(Node root){
        
        //basecase
        if(root == null) return 0;
        
        int LHeight = height(root.left);
        int RHeight = height(root.right);
        
        if(LHeight > RHeight) return LHeight+1;
        else                  return RHeight+1;
    }
}
