QUESTION LINK - https://practice.geeksforgeeks.org/problems/bipartite-graph/1
EXPLANATION LINK - 1. BFS APPROACH - https://www.youtube.com/watch?v=ZBhZ1DXGrhA
                   2. DFS APPROACH - https://www.youtube.com/watch?v=uC884ske2uQ&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=10
                     
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


-------------------------------------------------------------------------DFS APPROACH-------------------------------------------------------------------------------
  
class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int colour[] = new int[V];
        Arrays.fill(colour , -1);
        
        for(int i=0; i<V; i++){
            if(colour[i] == -1){
                if( !dfs(i , adj, colour) ){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean dfs(int i, ArrayList<ArrayList<Integer>> adj , int[] colour){
        
        if(colour[i] == -1)     colour[i] = 1;
        
        for(Integer nbr : adj.get(i)){
            
            if(colour[nbr] == -1){
                colour[nbr] = 1 - colour[i];
                
                if( !dfs(nbr , adj , colour)){
                    return false;
                }
            }
            else if(colour[nbr] == colour[i]){
                return false;
            }
        }
        
        return true;
    }
}
