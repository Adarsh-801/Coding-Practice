QUESTION LINK - https://practice.geeksforgeeks.org/problems/mirror-tree/1
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        
        //base case
        if(node == null) return;
        
        //now swap the left and right child
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        //now call the same fuction on left and right subtree
        mirror(node.left);
        mirror(node.right);
    }
}
