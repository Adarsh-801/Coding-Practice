QUESTION LINK - https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
  
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
