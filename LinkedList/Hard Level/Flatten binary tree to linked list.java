QUESTION LINK - https://practice.geeksforgeeks.org/problems/flatten-binary-tree-to-linked-list/1
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    public static void flatten(Node root)
    {
        if(root == null)    return;
        if(root.left == null && root.right == null) return;
        
        if(root.left != null){
            
            Node temp = root.right;
            root.right = root.left;
            root.left = null;
            
            Node current = root.right;
            while(current.right != null){
                current = current.right;
            }
            
            current.right = temp;
        }
        
        flatten(root.right);
    }
}
