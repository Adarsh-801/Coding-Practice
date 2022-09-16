QUESTION LINK - https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1
EXPLANATION LINK - https://www.youtube.com/watch?v=cvK3Sb6zJ1k
  
======================================================================ANSWER===========================================================================================
  
class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
           ArrayList<Integer> ans = new ArrayList<>();
           
           if(root == null) return ans;
           
           Queue<Node> q = new LinkedList<>();
           q.add(root);
           
           while(!q.isEmpty()){
               
               int size = q.size();
               for(int i=0; i<size; i++){
                   
                  Node curr = q.remove();
                  
                  while(curr != null){
                      ans.add(curr.data);
                      if(curr.left != null)     q.add(curr.left);
                      curr = curr.right;
                  }
               }
           }
           return ans;
      }
}
  
  

  
  
