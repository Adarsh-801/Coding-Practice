QUESTION LINK - https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
EXPLANATION LINK - https://www.youtube.com/watch?v=wTloJwckQTU
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    
    //this class contains 2 parameters
    // 1. horizontal distance of any node from the root 
    // 2. the Node itself
    static class Pair{
        
        int hd;         //horizontal distance
        Node node;      //tree node
        
        //constructor
        public Pair( int hd , Node node){
            this.hd = hd;
            this.node = node;
        }
    }
    
    
    
    public ArrayList <Integer> bottomView(Node root)
    {
        //we use tree map so that the keys are in sprted order
        Map<Integer , Integer> map = new TreeMap<>();
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add( new Pair( 0 , root));
        
        while(!q.isEmpty()){
             
             Pair current = q.poll();
             
             map.put( current.hd , current.node.data);
             
             if(current.node.left != null)  q.add( new Pair( current.hd-1 , current.node.left));
             if(current.node.right != null)  q.add( new Pair( current.hd+1 , current.node.right));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int key: map.keySet()){
            ans.add( map.get(key) );
        }
        
        return ans;
        
    }
}
