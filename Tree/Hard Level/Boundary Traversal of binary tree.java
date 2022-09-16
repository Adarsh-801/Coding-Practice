QUESTION LINK - https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
EXPLANATION LINK - https://www.youtube.com/watch?v=uemjIijtu2I&t=670s
  
======================================================================ANSWER===========================================================================================
  
class Solution{   
    
    ArrayList<Integer> a = new ArrayList<>(); //global variable

     ArrayList <Integer> boundary(Node root){
    
       if(root == null)     return a;
    
       if(root.left!=null)                      LeftLeaf(root,a);
       if(root.left==null&&root.right!=null)    a.add(root.data);
       
       Leaf(root,a);
       if(root.right!=null)     RightLeaf(root.right,a);
       
       return a;
     }
    
    
     ArrayList<Integer> LeftLeaf(Node root, ArrayList<Integer> a){
         
         if(root.left==null && root.right==null){
             return a;
         }
    
         a.add(root.data);
    
         if(root.left!=null)                            LeftLeaf(root.left,a);
         if(root.left == null && root.right != null)    LeftLeaf(root.right,a);
    
         return a;
     }
    
    
     ArrayList<Integer> RightLeaf(Node root, ArrayList<Integer> a){
    
         if(root.left == null && root.right==null){
            return a;
         }
    
         if(root.right!=null)                               RightLeaf(root.right,a);
         else if(root.right == null && root.left != null)   RightLeaf(root.left,a);
         a.add(root.data);
    
         return a;
     }
    
     ArrayList<Integer> Leaf(Node root, ArrayList<Integer> a){
    
         if(root.left == null && root.right == null){
             a.add(root.data);
             return a;    
         }
    
         if(root.left!=null)    Leaf(root.left,a);
    
         if(root.right!=null)   Leaf(root.right,a);
         
         return a;
     }
}
