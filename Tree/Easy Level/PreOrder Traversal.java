QUESTION LINK - https://practice.geeksforgeeks.org/problems/preorder-traversal/1
APPRAOCH - 1.RECURSIVE
           2.ITERATIVE
  
======================================================================ANSWER===========================================================================================
  
class BinaryTree
{
     
    
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        helper(root ,ans);
        return ans;
    }
    
    static void helper(Node root , ArrayList<Integer> ans) {
        if(root == null)    return;
        
        //preorder -> root-left-right
        ans.add(root.data);
        helper(root.left , ans);
        helper(root.right, ans);
    }

}


------------------------------------------------------------------ITERATIVE APPROACH-----------------------------------------------------------------------------------
  
class BinaryTree
{
    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        
        st.push(root);
        
        while(!st.isEmpty()){
            
            Node current = st.pop();
            ans.add(current.data);
            
            if(current.right != null){
                st.push(current.right);
            }
            
            if(current.left != null){
                st.push(current.left);
            }
        }
        
        return ans;
    }

}
