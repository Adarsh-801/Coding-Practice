QUESTION LINK - https://practice.geeksforgeeks.org/problems/level-order-traversal/1
EXPLANATION LINK - https://www.youtube.com/watch?v=ICpp88mcB-k
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    //Function to return the level order traversal of a tree.
    static ArrayList <Integer> levelOrder(Node node) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            
            Node current = q.poll();
            ans.add(current.data);
            
            if(current.left !=  null)   q.add(current.left);
            if(current.right != null)   q.add(current.right);
        }
        
        return ans;
    }
}
