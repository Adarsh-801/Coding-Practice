QUESTION LINK - https://practice.geeksforgeeks.org/problems/inorder-traversal/1
APPROACH - 1.RECURSION
           2.ITERATIVE
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    
    ArrayList<Integer> ans = new ArrayList<>();  //global variable
    
    ArrayList<Integer> inOrder(Node root) {
        
        //base case
        if(root == null) return ans;
        
        //inprder -> left - root - right
        inOrder(root.left);
        ans.add(root.data);
        inOrder(root.right);
        
        return ans;
        
        
    }
}

-------------------------------------------------------------------------------ITERATIVE APPROACH---------------------------------------------------------------------
  
class Solution {
    
    ArrayList<Integer> inOrder(Node root) {
    
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)    return ans;
        
        Stack<Node> st = new Stack<>();
        
        while(true){
            if(root != null){
                st.push(root);
                root = root.left;
            }
            else{
                //break out of while loop
                if(st.isEmpty())    break;
                
                root = st.pop();
                ans.add(root.data);
                root = root.right;
            }
        }
        
        return ans;
        
    }

  
VIDEO LINK - https://www.youtube.com/watch?v=nzmtCFNae9k
