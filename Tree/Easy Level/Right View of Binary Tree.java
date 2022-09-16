QUESTION LINK - https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1 
  
======================================================================ANSWER===========================================================================================
  
class Solution{
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node node) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null)    return ans;
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            int size_of_queue = q.size();
            
            for(int i=0; i<size_of_queue; i++){
                Node frontNode = q.poll();
                
                if(i==0) ans.add(frontNode.data);
                
                if(frontNode.right != null)  q.add(frontNode.right);
                if(frontNode.left != null)  q.add(frontNode.left);
            }
        }
        
        return ans;
    }
}
