QUESTION LINK - https://practice.geeksforgeeks.org/problems/possible-paths-between-2-vertices-1587115620/1
EXPLANATION LINK - https://www.youtube.com/watch?v=DrQ-eTN2v3A&t=777s
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    // Function to count paths between two vertices in a directed graph.
    
    int count = 0;
    
    public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
                   int destination) {
        
        boolean[] visited = new boolean[V];
        help(adj, source , destination, visited);
        
        return count;
    }
    
    public void help(ArrayList<ArrayList<Integer>> adj , int source , int destination ,
                    boolean[] visited){    
        
        if(source == destination){
            count++;
            return ;
        }
        
        visited[source] = true;
        
        for(int i : adj.get(source)){
            if(visited[i] == false){
                help(adj , i , destination, visited);
            }
        }
        
        visited[source] = false;
    }
}
