QUESTION LINK - https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
EXPLANATION LINK - coding ninjas
  
======================================================================ANSWER===========================================================================================
  
class Tree
{
    
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
	    if(root == null)    return true;
	    
	    int lh = height(root.left);
	    int rh = height(root.right);
	    
	    if(Math.abs(lh-rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
	        return true;
	   
	   return false;
    }
    
    public static int height(Node root){
        if(root == null) return 0;
        
        return Math.max( height(root.left) , height(root.right) ) + 1 ;
    }
}
