QUESTION LINK - https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
EXPLANATION LINK - https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
INDEX - 1. First code works only when there are no connected graphs
        2. Second code will work also there are connected graphs
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            
            ArrayList<Integer> ans = new ArrayList<>();
            
            boolean[] visited = new boolean[V+1];
            
            //for(int i=0; i<V; i++){
                
                //if(visited[i] == false){
                    
                    Queue<Integer> q = new LinkedList<>();
                    q.add(0);
                    visited[0] = true;
                    
                    while(!q.isEmpty()){
                        
                        int frontNode = q.poll();
                        ans.add(frontNode);
                        
                    for(Integer j : adj.get(frontNode)){
                        if(visited[j] == false){
                            visited[j] = true;
                            q.add(j);
                        }
                }
            }
            return ans;
            
    }
}



--------------------------------------------------------------------CODE 2-----------------------------------------------------------------------------------------
  
class Solution {
    
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            
            ArrayList<Integer> ans = new ArrayList<>();
            
            boolean[] visited = new boolean[V+1];
            
            for(int i=0; i<V; i++){
                
                if(visited[i] == false){
                    
                    Queue<Integer> q = new LinkedList<>();
                    q.add(0);
                    visited[0] = true;
                    
                    while(!q.isEmpty()){
                        
                        int frontNode = q.poll();
                        ans.add(frontNode);
                        
                    for(Integer j : adj.get(frontNode)){
                        if(visited[j] == false){
                            visited[j] = true;
                            q.add(j);
                        }
                }
            }
            return ans;
            
    }
}
