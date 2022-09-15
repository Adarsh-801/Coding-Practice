QUESTION LINK - https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1
  
======================================================================ANSWER===========================================================================================
  
class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            
            Node current = q.poll();
            ans.add(current.data);
            
            if(current.right != null)   q.add(current.right);
            if(current.left != null)    q.add(current.left);
        }
        
        Collections.reverse(ans);
        return ans;
        
        
    }
}      
