QUESTION LINK - https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1
APPROACH - Create a priority queue then add all the nodes to it then simply pop it because
           priority queue will pop it in order
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int KthSmallestElement(Node root, int K) {
        
        add(root);
        
        if(K > pq.size()) return -1;
        
        int ans = -1;
        for(int i=0; i<K; i++){
            ans = pq.remove();
        }
        
        return ans;

    }
    
    public void add(Node root){
        
        if(root == null) return;
        
        pq.add(root.data);
        add(root.left);
        add(root.right);
        
    }
}
