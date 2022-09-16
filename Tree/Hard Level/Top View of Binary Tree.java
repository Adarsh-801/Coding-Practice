QUESTION LINK - https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
EXPLANATION LINK - https://www.youtube.com/watch?v=wTloJwckQTU
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    //this class contains 2 parameters
    // 1. horizontal distance of any node from the root 
    // 2. the Node itself
   static class Pair{
       
        int hd;         //horizontal distance
        Node node;      // the tree node
        
        //constructor
        public Pair(int hd , Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    
    
    
    static ArrayList<Integer> topView(Node root)
    {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0 , root));
        
        //we use tree map so that the keys are in sprted order
        Map<Integer , Integer> map = new TreeMap<>();
        
        while(!q.isEmpty()){
            
            Pair temp = q.poll();
            
            if(!map.containsKey(temp.hd)){
                map.put(temp.hd , temp.node.data);
            }
            
            if(temp.node.left != null)  q.add( new Pair( temp.hd-1 , temp.node.left) );
            if(temp.node.right != null)  q.add( new Pair( temp.hd+1 , temp.node.right) );
            
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int key : map.keySet()){
            ans.add( map.get(key));
        }
        
        return ans;
    }
}
