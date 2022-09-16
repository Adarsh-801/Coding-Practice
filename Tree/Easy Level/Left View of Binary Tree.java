QUESTION LINK - https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
EXPLANATION LINK - https://www.youtube.com/watch?v=4Sav9w_x954
  
======================================================================ANSWER===========================================================================================
  
class Tree
{
    
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> ans = new ArrayList<>();
      
      Queue<Node> q = new LinkedList<>();
      
      if(root == null)  return ans;
      
      q.add(root);
      
      while(!q.isEmpty()){
          
          int size = q.size();
          for(int i=0; i<size; i++){
              Node temp = q.poll();
              
              if(i==0)  ans.add(temp.data);
              
              if(temp.left != null) q.add(temp.left);
              if(temp.right != null) q.add(temp.right);
          }
      }
      
      return ans;
    }
}
