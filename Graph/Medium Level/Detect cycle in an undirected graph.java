QUESTION LINK - https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
EXPLANATION LINK - https://www.youtube.com/watch?v=qbQq-k75bcY
APPROACH - 1. BFS APPROACH
           2. DFS APPROACH
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visited = new boolean[V];
        
        for(int i=0; i<V; i++){
            
            if(visited[i] == false){
                boolean ans = helper(i, adj , visited);
                
                if(ans) return true;
                
            }
        }
        return false;
    }
    
    public boolean helper(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        
        while(!q.isEmpty()){
            int frontNode = q.poll();
            
            if(visited[frontNode] == true){
                return true;
            }
            
            visited[frontNode] = true;
            
            for(Integer it : adj.get(frontNode)){
                
                if(visited[it] == false)    q.add(it);
            }
        }
        
        return false;
        
    }
}


----------------------------------------------------------------------DFS APPROACH----------------------------------------------------------------------------------
  
class Solution {
   // Function to detect cycle in an undirected graph.
   public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       // Code here
       
       boolean visited[]=new boolean[V];
       for(int i=0;i<V;i++)
       {
           if(!visited[i])
           if(isCyclic(visited,i,adj,-1))
           return true;
           
       }
       return false;
   }
   public boolean isCyclic(boolean visited[],int child,ArrayList<ArrayList<Integer>> adj,int parent)
   {
       visited[child]=true;
       
       for(int i=0;i<adj.get(child).size();i++)
       {
           if(!visited[adj.get(child).get(i)])
           {
           if(isCyclic(visited,adj.get(child).get(i),adj,child))
           return true;
           }
           else if(adj.get(child).get(i)!=parent)
           return true;
       }
       return false;
   }
}
