QUESTION LINK - https://practice.geeksforgeeks.org/problems/bipartite-graph/1
EXPLANATION LINK - https://www.youtube.com/watch?v=ZBhZ1DXGrhA
NOTE - A graph can be bipartite only when - 1. The graph is A-cyclic
                                            2. Even if the graph is cyclic the cycle has even number of vertices
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    
    class Pair{
        int vertex;
        int level;
        
        public Pair(int vertex , int level){
            this.vertex = vertex;
            this.level = level;
        }
    }
    
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int visited[] = new int[V];
        Arrays.fill(visited , -1);
        
        for(int i = 0; i<V; i++){
            
            if(visited[i] == -1){
                boolean isBipartite = bfs(i , adj , visited);
            
                if(isBipartite == false){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean bfs(int i, ArrayList<ArrayList<Integer>> adj, int[] visited){
        
        Queue<Pair> q = new ArrayDeque<>();
        q.add( new Pair(i , 0));
        
        while(!q.isEmpty()){
            
            Pair rem = q.poll();
            
            if(visited[rem.vertex] != -1){
                if(visited[rem.vertex] != rem.level){
                    return false;
                }
            }
            else{
                visited[rem.vertex] = rem.level;
            }
            
            for(Integer nbr : adj.get(rem.vertex)){
                if(visited[nbr] == -1){
                    q.add( new Pair(nbr , rem.level+1));
                }
            }
        }
        
        return true;
    }
}
