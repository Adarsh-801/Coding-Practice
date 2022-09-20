QUESTION LINK - https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
VIDEO LINK - Striver
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        return dfsHelp(adj , ans , 0);
    }
    
    public static ArrayList<Integer> dfsHelp(ArrayList<ArrayList<Integer>> adj , 
                                             ArrayList<Integer> ans , int src){
    
        ans.add(src);
        
        for(Integer i : adj.get(src)){
            
            if(!ans.contains(i)){
                dfsHelp(adj , ans , i);
            }
        }
        
        return ans;
                                                 
    }
}

----------------------------------------------------------------CODE FOR UNCONNECTED COMPONENTS OF GRAPH---------------------------------------------------------------
  
class Solution {
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[V];
        
        for(int i=0; i<V; i++){
            if(visited[i] == false){
                dfsHelper(i , adj , visited, ans);
            }
        }
        
        return ans;
    }
    
    public void dfsHelper(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans){
        
        ans.add(i);
        visited[i] = true;
        for(Integer it : adj.get(i)){
            if(visited[it] == false){
                dfsHelper(it , adj , visited, ans);
            }
        }
    }
}
