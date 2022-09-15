QUESTION LINK - https://practice.geeksforgeeks.org/problems/postorder-traversal/1
  
======================================================================ANSWER===========================================================================================
 
class Tree
{
    
    ArrayList<Integer> postOrder(Node root)
    {
       ArrayList<Integer> ans = new ArrayList<>();
       helper(root , ans);
       return ans;
    }
    
    void helper(Node root , ArrayList<Integer> ans){
        if(root == null)    return;
        
        helper(root.left , ans);
        helper(root.right , ans);
        ans.add(root.data);
    }
}

-------------------------------------------------------------ITERATIVE APPROACH---------------------------------------------------------------------------------------
  
class Tree
{
    
    ArrayList<Integer> postOrder(Node root)
    {
       ArrayList<Integer> ans =  new ArrayList<>();
       
       Stack<Node> st = new Stack<>();
       Stack<Node> tmp = new Stack<>();
       
       Node curr = root;
       st.add(root);
       
       while(st.size()>0){
           curr = st.pop();
           tmp.push(curr);
           if(curr.left!=null) st.push(curr.left);
           if(curr.right!=null) st.push(curr.right);
            
       }
       
       while(tmp.size()>0){
           ans.add(tmp.pop().data);
       }
       
       return ans;
    }
}


VIDEO LINK - https://www.youtube.com/watch?v=xLQKdq0Ffjg
